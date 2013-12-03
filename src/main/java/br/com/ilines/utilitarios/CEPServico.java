package br.com.ilines.utilitarios;

import br.com.ilines.dao.InterageDAO;
import br.com.ilines.endereco.CepAlias;
import br.com.ilines.endereco.Cidade;
import br.com.ilines.endereco.Endereco;
import br.com.ilines.endereco.Estado;
import br.com.ilines.endereco.Logradouro;
import br.com.ilines.endereco.Subregiao;
import br.com.ilines.endereco.dao.EnderecoDAO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

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
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> listaEnderecos = (List<Endereco>) enderecoDAO.pesquisaEnderecosPorCEP(cep);
        if (listaEnderecos.isEmpty()) {            
            if (cepMemoria.equals(cep)) {
                return;
            }
            if (cepMemoria.equals("")) {
                cepMemoria = cep;
            }
            String urlString = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=query_string";
            // os parametros a serem enviados
            Properties parameters = new Properties();
            parameters.setProperty("cep", cep);
            parameters.setProperty("formato", "xml");
            Iterator i = parameters.keySet().iterator();
            int counter = 0;
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
                XStream xstream = new XStream(new DomDriver());
                Annotations.configureAliases(xstream, CepAlias.class);
                xstream.alias("webservicecep", CepAlias.class);
                CepAlias cepAlias = (CepAlias) xstream.fromXML(newData.toString());            
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
        } else {
            endereco = new Endereco();
            if(listaEnderecos.size() == 1) {
                endereco = listaEnderecos.get(0);
            } else {
                endereco.setBairro(listaEnderecos.get(0).getBairro());
            }
        }
        cep = "";
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
