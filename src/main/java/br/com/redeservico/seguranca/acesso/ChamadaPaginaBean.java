package br.com.redeservico.seguranca.acesso;

import br.com.redeservico.seguranca.Rotina;
import br.com.redeservico.seguranca.Usuario;
import br.com.redeservico.seguranca.dao.RotinaDAO;
import br.com.redeservico.utilitarios.GenericaSessao;
import br.com.redeservico.utilitarios.MenuLinks;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class ChamadaPaginaBean {

    private final Usuario usuarioSessao = (Usuario) GenericaSessao.getObject("sessaoUsuario");
    private List<MenuLinks> menuLinks = new ArrayList<MenuLinks>();
    private int nivelLink = 0;
    private boolean carregaPagina = true;
    private boolean linkClicado = false;
    private HttpServletRequest paginaRequerida = null;
    public String verificaPermissao() {
        if (usuarioSessao != null) {
            if (usuarioSessao.getId() != -1) {

            }
        }
        return "index";
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
            if (linkAtual.equals("acessoNegado") || FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("indicaAcesso") == null) {
                carregaPagina = false;
                return;
            }
            if (linkAtual.equals("sessaoExpirou") || FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("indicaAcesso") == null) {
                carregaPagina = false;
                return;
            }
            if (linkAtual.equals("menuPrincipal") || linkAtual.equals("menuPrincipalAcessoWeb") || linkAtual.equals("menuPrincipalSuporteWeb")) {
                carregaPagina = true;
                nivelLink = 0;
            }
            if (carregaPagina) {
                linkClicado = false;
                boolean isNivel = false;
                boolean acessoCadastro = (Boolean) GenericaSessao.getBoolean("acessoCadastro");
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
                            menuLinks.add(new MenuLinks(0, "adminRedeServico", "Menu Administrativo Rede Servicos", true));
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
        GenericaSessao.remove("controleAcessoBean");
        return "login";
    }
    
    public String usuarioAdministrador() {
        GenericaSessao.remove("usuarioBean");
        GenericaSessao.remove("pesquisaPessoaBean");
        return "usuarioAdministrador";
    }
    
    // PESQUISAS
    
    public String pesquisaUsuario() {
        return "pesquisaUsuario";
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
