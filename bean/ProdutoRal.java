package bean;
// Generated 30/11/2023 16:17:26 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProdutoRal generated by hbm2java
 */
@Entity
@Table(name="produto_ral"
    ,catalog="db_rodrigo_ledesma"
)
public class ProdutoRal  implements java.io.Serializable {


     private int idprodutoRal;
     private String nomeRal;
     private String descricaoRal;
     private String tamanhoRal;
     private double precoRal;
    

    public ProdutoRal() {
    }

	
    public ProdutoRal(int idprodutoRal, String nomeRal, String descricaoRal, String tamanhoRal, double precoRal) {
        this.idprodutoRal = idprodutoRal;
        this.nomeRal = nomeRal;
        this.descricaoRal = descricaoRal;
        this.tamanhoRal = tamanhoRal;
        this.precoRal = precoRal;
    }
    public ProdutoRal(int idprodutoRal, String nomeRal, String descricaoRal, String tamanhoRal, double precoRal, Set compraProdutoRals) {
       this.idprodutoRal = idprodutoRal;
       this.nomeRal = nomeRal;
       this.descricaoRal = descricaoRal;
       this.tamanhoRal = tamanhoRal;
       this.precoRal = precoRal;
       
    }
   
     @Id 

    
    @Column(name="idproduto_ral", unique=true, nullable=false)
    public int getIdprodutoRal() {
        return this.idprodutoRal;
    }
    
    public void setIdprodutoRal(int idprodutoRal) {
        this.idprodutoRal = idprodutoRal;
    }

    
    @Column(name="nome_ral", nullable=false, length=45)
    public String getNomeRal() {
        return this.nomeRal;
    }
    
    public void setNomeRal(String nomeRal) {
        this.nomeRal = nomeRal;
    }

    
    @Column(name="descricao_ral", nullable=false, length=250)
    public String getDescricaoRal() {
        return this.descricaoRal;
    }
    
    public void setDescricaoRal(String descricaoRal) {
        this.descricaoRal = descricaoRal;
    }

    
    @Column(name="tamanho_ral", nullable=false, length=45)
    public String getTamanhoRal() {
        return this.tamanhoRal;
    }
    
    public void setTamanhoRal(String tamanhoRal) {
        this.tamanhoRal = tamanhoRal;
    }

    
    @Column(name="preco_ral", nullable=false, precision=10)
    public double getPrecoRal() {
        return this.precoRal;
    }
    
    public void setPrecoRal(double precoRal) {
        this.precoRal = precoRal;
    }


@Override
public String toString(){
    return getNomeRal();
}

@Override
public boolean equals(Object object){
    if(object instanceof ProdutoRal){
        ProdutoRal produtos = (ProdutoRal) object;
        if(this.getIdprodutoRal() == produtos.getIdprodutoRal()){
            return true;
        }
    }
    return false;
}
}

