package mb;

import repositorios.ListaComprasDAO;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelos.ListaCompras;
import modelos.ListaComprasItem;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class ListaComprasMB {

    private ListaComprasDAO dao;
    private List<ListaCompras> listas;
    private ListaCompras lista = new ListaCompras();
    private ArrayList<ListaComprasItem> itens = new ArrayList<ListaComprasItem>();
    private ListaComprasItem item;
    private String msg;

    public ListaComprasMB() {
        listas = new ArrayList<ListaCompras>();
        dao = new ListaComprasDAO();
        item = new ListaComprasItem();

        listas = dao.getAll();
        msg = "";
    }

    public void removeToItemList(ActionEvent e) {

        lista = (ListaCompras) e.getComponent().getAttributes().get("lista");
        item = (ListaComprasItem) e.getComponent().getAttributes().get("item");

        lista.getItens().remove(item);

        dao.save(lista);
        listas = dao.getAll();

    }

    public void excluirLista(ActionEvent e) {

        lista = (ListaCompras) e.getComponent().getAttributes().get("lista");

        dao.excluirLista(lista);
        listas = dao.getAll();

    }

    public void addSaveToItemList(ActionEvent e) {

        lista = (ListaCompras) e.getComponent().getAttributes().get("lista");
    }

    
    
    public void salvarNovoItem() {

        itens = lista.getItens();
        
        itens.add(item);
        
        lista.setItens(itens);

        this.salvar();

    }

    public void addToItemList() {

        itens.add(item);
        lista.setItens(itens);

        item = new ListaComprasItem();

    }

    public void editaItem(ActionEvent e) {
        item = (ListaComprasItem) e.getComponent().getAttributes().get("item");
        lista = (ListaCompras) e.getComponent().getAttributes().get("lista");

    }
 
       public void mudaEstado(ValueChangeEvent e) {

        FacesContext context = FacesContext.getCurrentInstance();
        Boolean novoValor = (Boolean) e.getNewValue();
        item = (ListaComprasItem) e.getComponent().getAttributes().get("item");
        
        item.setIsComprado(novoValor);
        lista = (ListaCompras) e.getComponent().getAttributes().get("lista");

        context.renderResponse();
        dao.save(lista);
       }

    public void salvar() {

        dao.save(lista);
        lista = new ListaCompras();

        listas = new ArrayList<ListaCompras>();
        item = new ListaComprasItem();
        itens = new ArrayList<ListaComprasItem>();

        listas = dao.getAll();

    }

    public List<ListaCompras> getListas() {
        return listas;
    }

    public void setListas(List<ListaCompras> listas) {
        this.listas = listas;
    }

    public ListaCompras getLista() {
        return lista;
    }

    public void setLista(ListaCompras lista) {
        this.lista = lista;
    }

    public ArrayList<ListaComprasItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ListaComprasItem> itens) {
        this.itens = itens;
    }

    public ListaComprasItem getItem() {
        return item;
    }

    public void setItem(ListaComprasItem item) {
        this.item = item;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
