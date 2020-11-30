package com.qsystems.persists;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Kornyukhina Sasha
 */

@Entity
@Table(name="forex_calendar")
public class CurrencyCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;


    @Column(name = "currency_value")
    private double currencyValue;


    public CurrencyCalendar() {
    }

    public CurrencyCalendar(Long id, LocalDate date, double currencyValue) {
        this.id = id;
        this.date = date;
        this.currencyValue = currencyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }
}
