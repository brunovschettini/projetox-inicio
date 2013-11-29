//package br.com.redeservico.edicao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "EDI_RECEITA")
//@NamedQuery(name = "EdicaoReceita.findById", query = "SELECT erec FROM EdicaoReceita erec WHERE erec.id=:pid")
//public class EdicaoReceita implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @JoinColumn(name = "ID_EDICAO", referencedColumnName = "ID")
//    @ManyToMany
//    private Edicao edicao;
//    @Column(name = "DS_UTENSILIO", length = 255)
//    private String utensilio;
//    @Column(name = "DS_INGREDIENTE", length = 255)
//    private String ingrediente;
//    @Column(name = "DS_RECHEIO", length = 255)
//    private String recheio;
//    @Column(name = "DS_RENDIMENTO", length = 255)
//    private String rendimento;
//    @Column(name = "DS_TEMPO_PREPARO", length = 255)
//    private String tempoPreparo;
//
//    public EdicaoReceita() {
//        this.id = -1;
//        this.edicao = new Edicao();
//        this.utensilio = "";
//        this.ingrediente = "";
//        this.recheio = "";
//        this.rendimento = "";
//        this.tempoPreparo = "";
//    }
//
//    public EdicaoReceita(int id, Edicao edicao, String utensilio, String ingrediente, String recheio, String rendimento, String tempoPreparo) {
//        this.id = id;
//        this.edicao = edicao;
//        this.utensilio = utensilio;
//        this.ingrediente = ingrediente;
//        this.recheio = recheio;
//        this.rendimento = rendimento;
//        this.tempoPreparo = tempoPreparo;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Edicao getEdicao() {
//        return edicao;
//    }
//
//    public void setEdicao(Edicao edicao) {
//        this.edicao = edicao;
//    }
//
//    public String getUtensilio() {
//        return utensilio;
//    }
//
//    public void setUtensilio(String utensilio) {
//        this.utensilio = utensilio;
//    }
//
//    public String getIngrediente() {
//        return ingrediente;
//    }
//
//    public void setIngrediente(String ingrediente) {
//        this.ingrediente = ingrediente;
//    }
//
//    public String getRecheio() {
//        return recheio;
//    }
//
//    public void setRecheio(String recheio) {
//        this.recheio = recheio;
//    }
//
//    public String getRendimento() {
//        return rendimento;
//    }
//
//    public void setRendimento(String rendimento) {
//        this.rendimento = rendimento;
//    }
//
//    public String getTempoPreparo() {
//        return tempoPreparo;
//    }
//
//    public void setTempoPreparo(String tempoPreparo) {
//        this.tempoPreparo = tempoPreparo;
//    }
//}
