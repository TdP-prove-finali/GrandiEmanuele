package it.polito.tdp.PF;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.PF.model.Model;
import it.polito.tdp.PF.model.Titolo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;

public class FXMLController {
	
	private Model model;
	
	private List<Titolo>titoli;

    @FXML
    private ResourceBundle resources;
    @FXML
    private CheckBox netflix2;
    
    @FXML
    private ComboBox<Integer> cmbAnno3;
    
    @FXML
    private CheckBox prime2;
    
    @FXML
    private CheckBox disneyplus2;
    
    @FXML
    private ComboBox<Integer> cmbAnno2;

    @FXML
    private URL location;
    
    @FXML
    private Button btnRc;

    @FXML
    private ComboBox<Titolo> CmbTitoli;

    @FXML
    private TextArea TxtArea;

    @FXML
    private Text TxtDuratTot;

    @FXML
    private TextField TxtDurata;

    @FXML
    private TextField TxtDurataMax;

    @FXML
    private TextArea TxtMarat;

    @FXML
    private TextArea TxtPlaylist;

    @FXML
    private TextArea TxtTrama;

    @FXML
    private TextField TxtVotomin;

    @FXML
    private Text ValutMigli;

    @FXML
    private Button btnAggiungi;

    @FXML
    private Button btnGenera;

    @FXML
    private Button btnReset2;

    @FXML
    private Button btnResetP;

    @FXML
    private Button btnresetR;

    @FXML
    private ComboBox<Integer> cmbAnno;

    @FXML
    private ComboBox<String> cmbGen2;

    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private ComboBox<String> comboGen;

    @FXML
    private CheckBox disneyplus;

   

    @FXML
    private CheckBox netflix;

    @FXML
    private CheckBox prime;

    @FXML
    private Slider slAlc;

    @FXML
    private Slider slNud;

    @FXML
    private Slider slPau;

    @FXML
    private Slider slViol;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private TabPane tb;

    @FXML
    private Text txtValMed;
    
    @FXML
    private ComboBox<Integer> cmbAnna;

    
    
    @FXML
    void hndlrc(ActionEvent event) {
    	btnresetR.setDisable(false);
    	TxtTrama.clear();
    	ValutMigli.setText("Valutazione Migliore");
    	
    	TxtArea.clear();
    	TxtArea.setStyle("-fx-text-fill: black");
    	CmbTitoli.getItems().clear();
    	titoli=new ArrayList<Titolo>();
if(cmbTipo.getValue()==null) {
	TxtArea.setText("Scegliere Film o Serie Tv");
	TxtArea.setStyle("-fx-text-fill: red");
	return;
}
    	if(!netflix.isSelected() && !prime.isSelected() && !disneyplus.isSelected()) {
    		TxtArea.setText("Scegliere Almeno una Piattaforma");
    		TxtArea.setStyle("-fx-text-fill: red");
    		return;	
    	}
    	
    	if(comboGen.getValue()==null && (cmbAnno.getValue()==null || cmbAnna.getValue()==null) ){
    		TxtArea.setText("Scegliere Almeno un genere o un periodo di uscita del Titolo");
    		TxtArea.setStyle("-fx-text-fill: red");
    		return;
    	}
    	if(TxtDurata.getText().equals("")) {
    		TxtArea.setText("Scegliere una durata massima dei titoli");
    		TxtArea.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	int N = 0;
    	try {
    		N = Integer.parseInt(TxtDurata.getText());
    	} catch(NumberFormatException ex) {
    		TxtArea.appendText("Inserire una durata valida");
    		TxtArea.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	if(cmbAnno.getValue()!=null && cmbAnna.getValue()!=null && cmbAnna.getValue()-cmbAnno.getValue()<20) {
    		TxtArea.setText("Scegliere un periodo sensato di almeno 20 anni");
    		TxtArea.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	if(netflix.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()!=null) {
    		titoli.addAll(model.dao.listTitoliNetflixGenAnno(cmbTipo.getValue(),comboGen.getValue(), cmbAnno.getValue(),Integer.parseInt(TxtDurata.getText()),cmbAnna.getValue()));
    	}
    	else if(netflix.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()==null) {
    		titoli.addAll(model.dao.listTitoliNetflixGen(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(TxtDurata.getText())));
    	}
    	else if(netflix.isSelected() && comboGen.getValue()==null && cmbAnno.getValue()!=null) {
    		titoli.addAll(model.dao.listTitoliNetflixAnno(cmbTipo.getValue(), cmbAnno.getValue(),Integer.parseInt(TxtDurata.getText()),cmbAnna.getValue()));
    	}
    	
    	if(prime.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()!=null) {
    		for(Titolo t : model.dao.listTitoliAmazonGenAnno(cmbTipo.getValue(),comboGen.getValue(), cmbAnno.getValue(),Integer.parseInt(TxtDurata.getText()),cmbAnna.getValue())) {
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    	}
    	else if(prime.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()==null) {
    		for(Titolo t:model.dao.listTitoliAmazonGen(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(TxtDurata.getText()))) {
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    		
    		
    	}
    	
    	
    	
    	else if(prime.isSelected() && comboGen.getValue()==null && cmbAnno.getValue()!=null) {
    		for(Titolo t: model.dao.listTitoliAmazonAnno(cmbTipo.getValue(),cmbAnno.getValue(),Integer.parseInt(TxtDurata.getText()),cmbAnna.getValue())) {
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    	}
    	
    	
    	
    	if(disneyplus.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()!=null) {
    		for(Titolo t:model.dao.listTitoliDisneyGenAnno(cmbTipo.getValue(),comboGen.getValue(), cmbAnno.getValue(),Integer.parseInt(TxtDurata.getText()),cmbAnna.getValue()) ){
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    	}
    	
    	
    	
    	else if(disneyplus.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()==null) {
    		for(Titolo t:model.dao.listTitoliDisneyGen(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(TxtDurata.getText()))) {
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    	}
    	
    	
    	
    	else if(disneyplus.isSelected() && comboGen.getValue()==null && cmbAnno.getValue()!=null) {
    		for(Titolo t:model.dao.listTitoliDisneyAnno(cmbTipo.getValue(), cmbAnno.getValue(),Integer.parseInt(TxtDurata.getText()),cmbAnna.getValue())) {
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    	}
    	
    	
    	
    	
    	
    	for(Titolo t: titoli) {
    		TxtArea.appendText(t+"\n");
    	}
    	
    	if(titoli.size()==0) {
    		TxtArea.setText("Non ci sono titoli che rispettino i filtri desiderati");
    		TxtArea.setStyle("-fx-text-fill: red");
    		return;
    	}
    	ValutMigli.setText("Valutazione Migliore: "+model.OrdinaeBest(titoli).getNome()+" ("+model.OrdinaeBest(titoli).getVoto()+")");
    	TxtTrama.setWrapText(true);
    	TxtTrama.setText(model.OrdinaeBest(titoli).getTrama());
    	
    	CmbTitoli.getItems().addAll(titoli);
    	
    	
    	
    }

    @FXML
    void handleAggPl(ActionEvent event) {
    	
    	btnResetP.setDisable(false);
    	if(CmbTitoli.getValue()==null) {
	TxtPlaylist.setText("Scegliere un titolo da aggiungere alla playlist");
	TxtPlaylist.setStyle("-fx-text-fill: red");
	return;
}
	Titolo t=CmbTitoli.getValue();
	
	TxtPlaylist.appendText(t.toString()+"\n");
	
	CmbTitoli.getItems().remove(t);
	
	
}
    

    @FXML
    void handleGen(ActionEvent event) {
    	btnReset2.setDisable(false);
    	TxtDuratTot.setText("Durata Totale");
    	 txtValMed.setText("Valutazione Media");
    	TxtMarat.clear();
    	TxtMarat.setWrapText(true);
    	TxtMarat.setStyle("-fx-text-fill: black");
    	if(!netflix2.isSelected() && !prime2.isSelected() && !disneyplus2.isSelected()) {
    		TxtMarat.setText("Scegliere Almeno una Piattaforma");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;	
    	}
    	
    	if(cmbAnno2.getValue()==null || cmbAnno3.getValue()==null) {
    		TxtMarat.setText("Scegliere un Periodo");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;	
    	}
    	
    	if(cmbGen2.getValue()==null) {
    		TxtMarat.setText("Scegliere un genere");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	if(TxtVotomin.getText().equals("")) {
    		TxtMarat.setText("Impostare un voto minimo per i titoli");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	int V = 0;
    	try {
    		V= Integer.parseInt(TxtVotomin.getText());
    	} catch(NumberFormatException ex) {
    		TxtMarat.appendText("Inserire una valutazione valida");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	if( TxtDurataMax.getText().equals("")) {
    		TxtMarat.setText("Impostare una durata massima per la Maratona");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	int D = 0;
    	try {
    		D= Integer.parseInt(TxtDurataMax.getText());
    	} catch(NumberFormatException ex) {
    		TxtMarat.appendText("Inserire una durata valida");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	
    	
    	
    	
    	List<String>Piattaforme=new ArrayList<String>();
    	if(netflix2.isSelected()) {
    		Piattaforme.add("N");
    	}
    	if(prime2.isSelected()) {
    		Piattaforme.add("P");
    	}
    	if(disneyplus2.isSelected()) {
    		Piattaforme.add("D");
    	}
    	
    	if(cmbAnno3.getValue()-cmbAnno2.getValue()>35 || cmbAnno3.getValue()-cmbAnno2.getValue()<=0) {
    		TxtMarat.setText("Selezionare un periodo sensato di massimo 30 anni");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	if(V<2 || V>9) {
    		TxtMarat.setText("Inserire una Valutazione compresa tra 2 e 9");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	if(D<3) {
    		TxtMarat.setText("Inserire una durata di almeno 3 ore");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	
    	
    	model.CreaGrafo(cmbGen2.getValue(), slNud.getValue(), slViol.getValue(), slAlc.getValue(), slPau.getValue(), Piattaforme, Integer.parseInt(TxtVotomin.getText()),Integer.parseInt(TxtDurataMax.getText())*60,cmbAnno2.getValue(),cmbAnno3.getValue());
    	
    	
    	if(model.CreaCammino(Integer.parseInt(TxtDurataMax.getText())*60)==null) {
    		TxtMarat.setText("Impossibile Generare una Maratona a partire da tali preferenze");
    		TxtMarat.setStyle("-fx-text-fill: red");
    		return;
    	}
    	List<Titolo>Maratona=model.CreaCammino(Integer.parseInt(TxtDurataMax.getText())*60);
    	for(Titolo t :Maratona) {
    		TxtMarat.appendText(t+"\n");
    	}
    	
    	TxtDuratTot.setText("Durata Tot: "+model.calcolopeso(Maratona)/60+" ore e "+model.calcolopeso(Maratona)%60+ " minuti");
    	txtValMed.setText("Valutazione Media: "+Math.round(model.calcolaValMedia(Maratona)*100.0)/100.0);
    	
    	
    }

    @FXML
    void handleReset2(ActionEvent event) {
TxtMarat.clear();
TxtDuratTot.setText("Durata Totale");
netflix2.selectedProperty().set(false);
prime2.selectedProperty().set(false);
disneyplus2.selectedProperty().set(false);
TxtDurataMax.setText("");
TxtVotomin.setText("");
cmbGen2.valueProperty().setValue(null);
slNud.setValue(3);
slViol.setValue(3);
slAlc.setValue(3);
slPau.setValue(3);
txtValMed.setText("Valutazione Media");
cmbAnno2.valueProperty().setValue(null);
cmbAnno3.valueProperty().setValue(null);
btnReset2.setDisable(true);
    }

    @FXML
    void handleResetPlay(ActionEvent event) {
TxtPlaylist.clear();
btnResetP.setDisable(true);
CmbTitoli.getItems().clear();
CmbTitoli.getItems().addAll(titoli);

    }

    @FXML
    void handleResetRic(ActionEvent event) {
comboGen.valueProperty().setValue(null);
cmbAnno.valueProperty().setValue(null);
TxtDurata.setText("");
cmbTipo.valueProperty().setValue(null);
TxtArea.clear();
ValutMigli.setText("Valutazione Migliore");
TxtTrama.clear();
CmbTitoli.getItems().clear();
netflix.selectedProperty().set(false);
prime.selectedProperty().set(false);
disneyplus.selectedProperty().set(false);
btnresetR.setDisable(true);
cmbAnna.valueProperty().setValue(null);
    }

    @FXML
    void initialize() {
        assert CmbTitoli != null : "fx:id=\"CmbTitoli\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtArea != null : "fx:id=\"TxtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtDuratTot != null : "fx:id=\"TxtDuratTot\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtDurata != null : "fx:id=\"TxtDurata\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtDurataMax != null : "fx:id=\"TxtDurataMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtMarat != null : "fx:id=\"TxtMarat\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtPlaylist != null : "fx:id=\"TxtPlaylist\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtTrama != null : "fx:id=\"TxtTrama\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtVotomin != null : "fx:id=\"TxtVotomin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ValutMigli != null : "fx:id=\"ValutMigli\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRc != null : "fx:id=\"btnRc\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset2 != null : "fx:id=\"btnReset2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnResetP != null : "fx:id=\"btnResetP\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnresetR != null : "fx:id=\"btnresetR\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAnno != null : "fx:id=\"cmbAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbGen2 != null : "fx:id=\"cmbGen2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbTipo != null : "fx:id=\"cmbTipo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert comboGen != null : "fx:id=\"comboGen\" was not injected: check your FXML file 'Scene.fxml'.";
        assert disneyplus != null : "fx:id=\"disneyplus\" was not injected: check your FXML file 'Scene.fxml'.";
        assert disneyplus2 != null : "fx:id=\"disneyplus2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAnno2 != null : "fx:id=\"cmbAnno2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert netflix != null : "fx:id=\"netflix\" was not injected: check your FXML file 'Scene.fxml'.";
        assert netflix2 != null : "fx:id=\"netflix2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert prime != null : "fx:id=\"prime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert prime2 != null : "fx:id=\"prime2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert slAlc != null : "fx:id=\"slAlc\" was not injected: check your FXML file 'Scene.fxml'.";
        assert slNud != null : "fx:id=\"slNud\" was not injected: check your FXML file 'Scene.fxml'.";
        assert slPau != null : "fx:id=\"slPau\" was not injected: check your FXML file 'Scene.fxml'.";
        assert slViol != null : "fx:id=\"slViol\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tab1 != null : "fx:id=\"tab1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tab2 != null : "fx:id=\"tab2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tb != null : "fx:id=\"tb\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtValMed != null : "fx:id=\"txtValMed\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAnno3 != null : "fx:id=\"cmbAnno3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAnna != null : "fx:id=\"cmbAnna\" was not injected: check your FXML file 'Scene.fxml'.";

        

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	comboGen.getItems().addAll(model.generi);
    	cmbGen2.getItems().addAll(model.generi);
    	cmbTipo.getItems().add("Film");
    	cmbTipo.getItems().add("Series");
    	cmbAnno.getItems().add(1930);
    	cmbAnno.getItems().add(1950);
    	cmbAnno.getItems().add(1970);
    	cmbAnno.getItems().add(1990);
    	cmbAnno.getItems().add(2000);
    	
    	cmbAnna.getItems().add(1960);
    	cmbAnna.getItems().add(1980);
    	cmbAnna.getItems().add(2000);
    	cmbAnna.getItems().add(2010);
    	cmbAnna.getItems().add(2021);
    	
    	
    	cmbAnno2.getItems().add(1930);
    	cmbAnno2.getItems().add(1950);
    	cmbAnno2.getItems().add(1970);
    	cmbAnno2.getItems().add(1990);
    	cmbAnno2.getItems().add(2000);
    	
    	cmbAnno3.getItems().add(1960);
    	cmbAnno3.getItems().add(1980);
    	cmbAnno3.getItems().add(2000);
    	cmbAnno3.getItems().add(2010);
    	cmbAnno3.getItems().add(2021);
    
    }

}



