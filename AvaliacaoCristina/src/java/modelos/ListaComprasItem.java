package modelos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "lista_compras_item")
public class ListaComprasItem implements Serializable {

    public void ListaComprasItem() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEG_B")
    @Column(name = "lista_compras_item_id")
    private int id;
    private String nome;

    @Column(name = "preco")
    private double preco;

    @Column(name = "isComprado")
    private boolean isComprado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isIsComprado() {
        return isComprado;
    }

    public void setIsComprado(boolean isComprado) {
        this.isComprado = isComprado;
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof ListaComprasItem) && (o != null)) {
            return (this.getId() == ((ListaComprasItem) o).getId());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        return hash;
    }
}
