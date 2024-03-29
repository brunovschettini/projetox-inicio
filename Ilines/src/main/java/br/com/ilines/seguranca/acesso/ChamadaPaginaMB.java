package br.com.ilines.seguranca.acesso;

import br.com.ilines.seguranca.Rotina;
import br.com.ilines.seguranca.Usuario;
import br.com.ilines.seguranca.dao.RotinaDAO;
import br.com.ilines.utilitarios.GenericaSessao;
import br.com.ilines.utilitarios.MenuLinks;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class ChamadaPaginaMB implements Serializable {

    private final Usuario usuarioSessao = (Usuario) GenericaSessao.getObject("sessaoUsuario");
    private List<MenuLinks> menuLinks = new ArrayList<MenuLinks>();
    private int nivelLink = 0;
    private boolean carregaPagina = true;
    private boolean linkClicado = false;
    private int tipoPagina = 0;
    private String urlAtual = "";
    private HttpServletRequest paginaRequerida = null;
    
    // MÓDULOS    
    private final int SEGURANCA = 1;
    private final int SERVICO = 2;
    private final int SITE = 3;
    private final int ESPORTE = 4;
    private final int FINANCEIRO = 5;
    private final int LOJA = 6;
    private final int ATENDIMENTO = 7;

    public String metodoGenerico(int tipo, String pagina) {
        paginaRequerida = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        urlAtual = converteURL(paginaRequerida.getRequestURI());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("urlRetorno", urlAtual);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("linkClicado", true);
        carregaPagina = true;
        tipoPagina = tipo;
        return pagina;
    }

    public String getHistoricoMenu() {
        String urlDestino = ((HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest())).getRequestURI();
        String linkAtual = converteURL(urlDestino);
        String linkRetorno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("urlRetorno");
        getHistoricoMenu(urlDestino, linkAtual, linkRetorno);
        return null;
    }

    public void getHistoricoMenu(String urlDestino, String linkAtual, String linkRetorno) {
        try {
            if (linkRetorno == null) {
                linkRetorno = "";
            }
            if (linkAtual.equals("acessoNegado") || !GenericaSessao.exists("indicaAcesso")) {
                carregaPagina = false;
                return;
            }
            if (linkAtual.equals("sessaoExpirou") || !GenericaSessao.exists("indicaAcesso")) {
                carregaPagina = false;
                return;
            }
            if (linkAtual.equals("admin")) {
                carregaPagina = true;
                nivelLink = 0;
            }
            if (carregaPagina) {
                linkClicado = false;
                boolean isNivel = false;
                boolean acessoCadastro = false;
                if (GenericaSessao.exists("acessoCadastro")) {
                    acessoCadastro = GenericaSessao.getBoolean("acessoCadastro");
                }
                if (nivelLink >= 0 && nivelLink <= 9) {
                    isNivel = true;
                    carregaPagina = false;
                }
                if (nivelLink >= 3 && nivelLink <= 9) {
                    GenericaSessao.put("acessoCadastro", false);
                }
                int nivel = 0;
                switch (nivelLink) {
                    case 0:
                        if ((GenericaSessao.getString("indicaAcesso")).equals("local")) {
                            limparMenuLinks(-1);
                            menuLinks.add(new MenuLinks(0, "admin", "Principal", true));
                            isNivel = false;
                        }
                        nivel = nivelLink;
                        nivelLink = 1;
                        break;
                    case 1:
                        nivel = nivelLink;
                        nivelLink = 2;
                        break;
                    case 2:
                        nivel = nivelLink;
                        nivelLink = 3;
                        break;
                    case 3:
                        if (acessoCadastro) {
                            nivel = 2;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 4;
                        }
                        break;
                    case 4:
                        if (acessoCadastro) {
                            nivel = 3;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 5;
                        }
                        break;
                    case 5:
                        if (acessoCadastro) {
                            nivel = 4;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 6;
                        }
                        break;
                    case 6:
                        if (acessoCadastro) {
                            nivel = 5;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 7;
                        }
                        break;
                    case 7:
                        if (acessoCadastro) {
                            nivel = 6;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 8;
                        }
                        break;
                    case 8:
                        if (acessoCadastro) {
                            nivel = 7;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 9;
                        }
                        break;
                    case 9:
                        if (acessoCadastro) {
                            nivel = 8;
                        } else {
                            nivel = nivelLink;
                            nivelLink = 10;
                        }
                        break;
                }
                if (isNivel) {
                    menuLinks.add(nivel, new MenuLinks(nivel, linkAtual, converteURLNome(linkAtual), true));
                }
                if (acessoCadastro) {
//                    int count = 0;
//                    List<MenuLinks> listRemove = new ArrayList<MenuLinks>();
//                    for (int i = 0; i < menuLinks.size(); i++) {
//                        if (menuLinks.get(i).getLink().equals(linkAtual)) {
//                            listRemove.add(menuLinks.get(i));
//                            count++;
//                        }
//                    }
//                    if (count > 0) {
//                        for (int i = 0; i < menuLinks.size(); i++) {
//                            for (int x = 0; x < listRemove.size(); x++) {
//                                count = 0;
//                                if (menuLinks.get(i).getLink().equals(listRemove.get(x).getLink())) {
//                                    if (count == 0) {
//                                        count = 1;
//                                    }
//                                    if (count == 1) {
//                                        menuLinks.remove(i);
//                                    }
//                                }
//                            }
//                        }
//                    }
                }
            } else if (linkRetorno.equals(linkAtual)) {
                for (int x = 0; x < menuLinks.size(); x++) {
                    if (menuLinks.get(x).getLink().equals(linkRetorno)) {
                        limparMenuLinks(x);
                        break;
                    }
                }
            } else {
                for (int x = 0; x < menuLinks.size(); x++) {
                    if (menuLinks.get(x).getLink().equals(linkAtual)) {
                        limparMenuLinks(x);
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public String login() {
        GenericaSessao.remove("controleAcessoMB");
        menuLinks.clear();
        return "login";
    }

    // CHAMADA DE MENUS
    
    
    
    // CHAMADA DE PÁGINAS
    
    public String usuarioAdministrador() {
        GenericaSessao.remove("usuarioMB");
        GenericaSessao.remove("pesquisaPessoaMB");
        return metodoGenerico(2, "usuarioAdministrador");
    }

    public String pessoaFisica() {
        GenericaSessao.remove("fisicaMB");
        GenericaSessao.remove("pesquisaPessoaFisicaMB");
        return metodoGenerico(2, "pessoaFisica");
    }

    // PESQUISAS
    public String pesquisaUsuario() {
        return metodoGenerico(1, "pesquisaUsuario");
    }

    public String pesquisaPessoaFisica() {
        return metodoGenerico(1, "pesquisaPessoaFisica");
    }

    public List<MenuLinks> getMenuLinks() {
        return menuLinks;
    }

    public void setMenuLinks(List<MenuLinks> menuLinks) {
        this.menuLinks = menuLinks;
    }

    public void limparMenuLinks(int indice) {
        for (int i = 0; i < this.menuLinks.size(); i++) {
            if (indice < i) {
                this.menuLinks.remove(i);
            }
            if (indice == -1) {
                this.menuLinks.clear();
                break;
            }
        }
    }

    public String cliqueMenuLinks(int i) {
        GenericaSessao.put("linkClicado", true);
        if (this.menuLinks.get(i).getLink().equals("")) {
            this.menuLinks.get(i - 1).setIndice(i);
            return this.menuLinks.get(i - 1).getLink();
        }
        this.nivelLink = i + 1;
        menuLinks.get(i).setIndice(i);
        return this.menuLinks.get(i).getLink();
    }

    // Lista Breadcrumbs e Menu url de retornos de páginas
    public String converteURLNome(String stringURL) {
        RotinaDAO rotinaDAO = new RotinaDAO();
        Rotina r = rotinaDAO.pesquisaRotinaPorPagina(stringURL);
        String nomePagina = " Menu ";
        if (r.getId() != -1) {
            if (!r.getRotina().equals("")) {
                nomePagina = r.getRotina();
                return nomePagina;
            }
        }
        return nomePagina;
    }

    public String converteURL(String urlDest) {
        return urlDest.substring(urlDest.lastIndexOf("/") + 1, urlDest.lastIndexOf("."));
    }

}
