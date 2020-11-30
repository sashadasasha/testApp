package com.qsystems.persists;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kornyukhina Sasha
 */

@Entity
@Table(name="forex_rate")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "currency_name")
    private String name;
    @Column(name = "currency_abbr")
    private String abbr;
    @Column(name = "units")
    private short quantityPerUnit;

    @OneToMany
    @JoinColumn(name = "currency_id")
    private List<CurrencyCalendar> calendarList;

    public Currency() {
    }

    public Currency(Integer id) {
        this.id = id;
    }

    public Currency(Integer id, String name, String abbr, short quantityPerUnit) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
        this.quantityPerUnit = quantityPerUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public short getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(short quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public List<CurrencyCalendar> getList() {
        return calendarList;
    }
}
