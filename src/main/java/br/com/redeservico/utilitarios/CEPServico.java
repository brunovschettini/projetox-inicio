package br.com.redeservico.utilitarios;

import br.com.redeservico.db.InterageDAO;
import br.com.redeservico.endereco.CepAlias;
import br.com.redeservico.endereco.Cidade;
import br.com.redeservico.endereco.Endereco;
import br.com.redeservico.endereco.Estado;
import br.com.redeservico.endereco.Logradouro;
import br.com.redeservico.endereco.Subregiao;
import br.com.redeservico.endereco.db.EnderecoDAO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class CEPServico {

    private String cep = "";
    private String cepMemoria = "";
    private Endereco endereco = new Endereco();

    /**
     * http://www.republicavirtual.com.br/cep/exemplos.php
     *
     * @param cep
     */
    public void procurar() {
        if (cepMemoria.equals(cep)) {
            return;
        }
        if (cepMemoria.equals("")) {
            cepMemoria = cep;
        }
        //  filialDep = request.getRequestURL().toString();
        // filialDep = requestFilial.getQueryString();
        String urlString = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=query_string";
        // os parametros a serem enviados
        Properties parameters = new Properties();
        parameters.setProperty("cep", cep);
        parameters.setProperty("formato", "xml");

        // o iterador, para criar a URL
        Iterator i = parameters.keySet().iterator();
        // o contador
        int counter = 0;

        // enquanto ainda existir parametros
        while (i.hasNext()) {
            String name = (String) i.next();
            String value = parameters.getProperty(name);
            urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;
        }
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Request-Method", "GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer newData = new StringBuffer();
            String s = "";
            while (null != ((s = br.readLine()))) {
                newData.append(s);
            }
            br.close();
            // Controi classe a partir do XML 
            XStream xstream = new XStream(new DomDriver());
            Annotations.configureAliases(xstream, CepAlias.class);
            xstream.alias("webservicecep", CepAlias.class);
            CepAlias cepAlias = (CepAlias) xstream.fromXML(newData.toString());
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            InterageDAO interageDAO = new InterageDAO();
            Estado estado = enderecoDAO.pesquisaEstadoPorDescricao(cepAlias.getUf());
            if (estado == null) {
                estado = new Estado();
                estado.setSigla(cepAlias.getUf());
                interageDAO.openTransaction();
                if (interageDAO.insert(estado)) {
                    interageDAO.commit();
                } else {
                    interageDAO.rollback();
                    return;
                }
            }            
            Cidade cidade = enderecoDAO.pesquisaCidadeEstadoPorDescricao(cepAlias.getCidade(), estado.getId());
            if (cidade == null) {
                cidade = new Cidade();
                cidade.setDescricao(cepAlias.getCidade());
                cidade.setSubregiao((Subregiao) interageDAO.findObjectByID(1, "Subregiao"));
                cidade.setEstado(estado);
                interageDAO.openTransaction();
                if (interageDAO.insert(cidade)) {
                    interageDAO.commit();
                } else {
                    interageDAO.rollback();
                    return;
                }
            }
            Logradouro logradouro = enderecoDAO.pesquisaLogradouroPorDescricao(cepAlias.getTipo_logradouro());
            if (logradouro == null) {
                logradouro = new Logradouro();
                logradouro.setDescricao(cepAlias.getTipo_logradouro());
                interageDAO.openTransaction();
                if (interageDAO.insert(logradouro)) {
                    interageDAO.commit();
                } else {
                    interageDAO.rollback();
                    return;
                }
            }
            endereco = new Endereco();
            endereco.setCep(cep);
            endereco.setBairro(cepAlias.getBairro());
            endereco.setCidade(cidade);
            endereco.setDescricaoEndereco(cepAlias.getLogradouro());
            endereco.setLogradouro(logradouro);
            Endereco enderecox = enderecoDAO.enderecoExiste(endereco);
            if (enderecox == null) {
                interageDAO.openTransaction();
                if (interageDAO.insert(endereco)) {
                    interageDAO.commit();
                } else {
                    interageDAO.rollback();
                }
            } else {
                endereco = new Endereco();
                endereco = enderecox;
            }
        } catch (IOException e) {
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCepMemoria() {
        return cepMemoria;
    }

    public void setCepMemoria(String cepMemoria) {
        this.cepMemoria = cepMemoria;
    }
}
