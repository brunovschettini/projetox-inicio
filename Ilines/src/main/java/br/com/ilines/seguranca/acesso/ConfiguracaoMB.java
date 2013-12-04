package br.com.ilines.seguranca.acesso;

import br.com.ilines.dao.InterageDAO;
import br.com.ilines.seguranca.Configuracao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConfiguracaoMB {

    private Configuracao configuracao = new Configuracao();

    public String init() {
        if (this.configuracao.getId() == -1) {
            InterageDAO interageDAO = new InterageDAO();
            this.configuracao = (Configuracao) interageDAO.findObjectByID(1, "Configuracao");
        }
        return null;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

}
