/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import java.util.Objects;

/**
 *
 * @author Marcelo
 */
public class SQLCondicao {
    
    public static SQLCondicao AND = new SQLCondicao(1, "E", "AND");
    public static SQLCondicao OR = new SQLCondicao(2, "OU", "OR");
    public static SQLCondicao DESCONHECIDO = new SQLCondicao(-1, "Desconhecido", "");
    
    public static SQLCondicao[] getArray() {
        return new SQLCondicao[] {AND, OR};
    }
    
    public static SQLCondicao getByCodigo(Integer codigo) {
        for(SQLCondicao p : getArray()) {
            if(p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return DESCONHECIDO;
    }
    
    private Integer codigo;
    private String descricao;
    private String condicao;

    public SQLCondicao(Integer codigo, String descricao, String condicao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.condicao = condicao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SQLCondicao other = (SQLCondicao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
}
