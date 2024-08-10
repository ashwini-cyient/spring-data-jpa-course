package com.example.demo.entitiy;

import jakarta.persistence.*;

@Entity(name = "LibraryCard")
@Table(name = "library_card", uniqueConstraints = {
        @UniqueConstraint(name = "student_card_number_unique", columnNames = "card_number")
})
public class LibraryCard {
    @Id
    @SequenceGenerator(name = "library_card_sequence",sequenceName = "library_card_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "library_card_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "card_number", nullable = false, columnDefinition = "TEXT", unique = true, length = 15)
    private String cardNumber;

    @OneToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id" , foreignKey = @ForeignKey(name = "library_card_student_id_fk"))
    private Student student;

    public LibraryCard() {
    }

    public LibraryCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LibraryCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}



