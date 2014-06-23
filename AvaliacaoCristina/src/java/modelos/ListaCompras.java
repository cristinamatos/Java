package modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "lista_compras")
public class ListaCompras implements Serializable {

    public void ListaCompras() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEG_B")
    @Column(name = "lista_compras_id")
    private int id;
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "lista_compras_id")
    private ArrayList<ListaComprasItem> itens;
    

    public double getTotalLista()
    {
        double total= 0;
        
        for (ListaComprasItem item : itens) {
            total +=  item.getPreco();
        }    
        return total;
    }   
    

    public ArrayList<ListaComprasItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ListaComprasItem> itens) {
        this.itens = itens;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
        
    @Override
    public boolean equals(Object o) {
        if ((o instanceof ListaCompras) && (o != null)) {
            return (this.getId()== ((ListaCompras) o).getId());
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
