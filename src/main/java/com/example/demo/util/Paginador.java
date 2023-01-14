package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class Paginador<T> {
    private String url;
    private Page<T> pagina;
    private int totalPaginas;
    private int elementosPorPaginas;
    private int paginaActual;
    private List<PaginaItem> paginas;

    public Paginador(String url, Page<T> pagina) {
        this.url = url;
        this.pagina = pagina;
        this.elementosPorPaginas = pagina.getSize();
        this.totalPaginas = pagina.getTotalPages();
        this.paginaActual = pagina.getNumber() + 1;
        this.paginas = new ArrayList<>();

        int desde, hasta;
        

        if(totalPaginas <= elementosPorPaginas){
            desde = 1;
            hasta = totalPaginas;
        } else{
            if(paginaActual <= elementosPorPaginas/2){
                desde = 1;
                hasta = elementosPorPaginas;
            } else if(paginaActual >= totalPaginas - elementosPorPaginas/2){
                desde = totalPaginas - elementosPorPaginas + 1;
                hasta = elementosPorPaginas;
            } else{
                desde = paginaActual - elementosPorPaginas / 2;
                hasta = elementosPorPaginas;
            }
        }

        for (int i = 0; i < hasta; i++) {
            paginas.add(new PaginaItem(desde + i, paginaActual == desde + i));
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page<T> getPagina() {
        return pagina;
    }

    public void setPagina(Page<T> pagina) {
        this.pagina = pagina;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getElementosPorPaginas() {
        return elementosPorPaginas;
    }

    public void setElementosPorPaginas(int elementosPorPaginas) {
        this.elementosPorPaginas = elementosPorPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public List<PaginaItem> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<PaginaItem> paginas) {
        this.paginas = paginas;
    }

    public boolean isFirst(){
        return this.pagina.isFirst();
    }

    public boolean isLast(){
        return this.pagina.isLast();
    }

    public boolean hasNext(){
        return this.pagina.hasNext();
    }

    public boolean hasPrevious(){
        return this.pagina.hasPrevious();
    }
}
