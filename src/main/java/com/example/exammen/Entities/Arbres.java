package com.example.exammen.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Arbres")
public class Arbres {
    @Id
    @Column(name = "arbres_idbase")
    private BigDecimal arbresIdbase;

    @Column(name = "arbres_domanialite")
    private String arbresDomanialite;

    @Column(name = "arbres_arrondissement")
    private String arbresArrondissement;

    @Column(name = "arbres_complementadresse")
    private String arbresComplementadresse;

    @Column(name = "arbres_numero")
    private String arbresNumero;

    @Column(name = "arbres_adresse")
    private String arbresAdresse;

    @Column(name = "arbres_circonferenceencm")
    private Float arbresCirconferenceencm;

    @Column(name = "arbres_hauteurenm")
    private Float arbresHauteurenm;

    @Column(name = "arbres_stadedeveloppement")
    private String arbresStadedeveloppement;

    @Column(name = "arbres_pepiniere")
    private String arbresPepiniere;

    @Column(name = "arbres_genre")
    private String arbresGenre;

    @Column(name = "arbres_espece")
    private String arbresEspece;

    @Column(name = "arbres_varieteoucultivar")
    private String arbresVarieteoucultivar;

    @Column(name = "arbres_dateplantation")
    private Date arbresDateplantation;

    @Column(name = "arbres_libellefrancais")
    private String arbresLibellefrancais;

    @Column(name = "com_idbase")
    private Float comIdbase;

    @Column(name = "com_idarbre")
    private Float comIdarbre;

    @Column(name = "com_site")
    private String comSite;

    @Column(name = "com_adresse")
    private String comAdresse;

    @Column(name = "com_complement_adresse")
    private String comComplementAdresse;

    @Column(name = "com_arrondissement")
    private String comArrondissement;

    @Column(name = "com_domanialite")
    private String comDomanialite;

    @Column(name = "com_nom_usuel")
    private String comNomUsuel;

    @Column(name = "com_nom_latin")
    private String comNomLatin;

    @Column(name = "com_autorite_taxo")
    private String comAutoriteTaxo;

    @Column(name = "com_annee_plantation")
    private String comAnneePlantation;

    @Column(name = "com_qualification_rem")
    private String comQualificationRem;

    @Column(name = "com_resume")
    private String comResume;

    @Column(name = "com_descriptif")
    private String comDescriptif;

    @Column(name = "com_delib_num")
    private String comDelibNum;

    @Column(name = "com_delib_date")
    private Date comDelibDate;

    @Column(name = "com_label_arbres")
    private String comLabelArbres;

    @Column(name = "com_url_pdf")
    private String comUrlPdf;

    @Column(name = "com_url_photo1")
    private String comUrlPhoto1;

    @Column(name = "com_copyright1")
    private String comCopyright1;
}
