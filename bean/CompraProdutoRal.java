package bean;
// Generated 30/11/2023 16:17:26 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CompraProdutoRal generated by hbm2java
 */
@Entity
@Table(name="compraProduto_ral"
    ,catalog="db_rodrigo_ledesma"
)
public class CompraProdutoRal  implements java.io.Serializable {


     private int idcompraProdutoRal;
     private CompraRal compraRal;
     private ProdutoRal produtoRal;
     private int quantidadeRal;
     private double valorUnitarioRal;

    public CompraProdutoRal() {
    }

    public CompraProdutoRal(int idcompraProdutoRal, CompraRal compraRal, ProdutoRal produtoRal, int quantidadeRal, double valorUnitarioRal) {
       this.idcompraProdutoRal = idcompraProdutoRal;
       this.compraRal = compraRal;
       this.produtoRal = produtoRal;
       this.quantidadeRal = quantidadeRal;
       this.valorUnitarioRal = valorUnitarioRal;
    }
   
     @Id 

    
    @Column(name="idcompraProduto_ral", unique=true, nullable=false)
    public int getIdcompraProdutoRal() {
        return this.idcompraProdutoRal;
    }
    
    public void setIdcompraProdutoRal(int idcompraProdutoRal) {
        this.idcompraProdutoRal = idcompraProdutoRal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_compra_ral", nullable=false)
    public CompraRal getCompraRal() {
        return this.compraRal;
    }
    
    public void setCompraRal(CompraRal compraRal) {
        this.compraRal = compraRal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_produto_ral", nullable=false)
    public ProdutoRal getProdutoRal() {
        return this.produtoRal;
    }
    
    public void setProdutoRal(ProdutoRal produtoRal) {
        this.produtoRal = produtoRal;
    }

    
    @Column(name="quantidade_ral", nullable=false)
    public int getQuantidadeRal() {
        return this.quantidadeRal;
    }
    
    public void setQuantidadeRal(int quantidadeRal) {
        this.quantidadeRal = quantidadeRal;
    }

    
    @Column(name="valorUnitario_ral", nullable=false, precision=10)
    public double getValorUnitarioRal() {
        return this.valorUnitarioRal;
    }
    
    public void setValorUnitarioRal(double valorUnitarioRal) {
        this.valorUnitarioRal = valorUnitarioRal;
    }

    



}


