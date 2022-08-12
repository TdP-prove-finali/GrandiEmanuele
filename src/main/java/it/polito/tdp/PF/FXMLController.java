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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;
    @FXML
    private CheckBox netflix2;
    
    @FXML
    private CheckBox prime2;
    
    @FXML
    private CheckBox disneyplus2;
    
    @FXML
    private ComboBox<String> cmbAnno2;

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
    private ComboBox<String> cmbAnno;

    @FXML
    private ComboBox<String> cmbGen2;

    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private ComboBox<String> comboGen;

    @FXML
    private CheckBox disneyplus;

    @FXML
    private ImageView image;

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
    void hndlrc(ActionEvent event) {
    	TxtArea.clear();
    	CmbTitoli.getItems().clear();
    	List <Titolo>titoli=new ArrayList<Titolo>();
if(cmbTipo.getValue()==null) {
	TxtArea.setText("Scegliere Film o Serie Tv");
	return;
}
    	if(!netflix.isSelected() && !prime.isSelected() && !disneyplus.isSelected()) {
    		TxtArea.setText("Scegliere Almeno una Piattaforma");
    		return;	
    	}
    	
    	if(comboGen.getValue()==null && cmbAnno.getValue()==null) {
    		TxtArea.setText("Scegliere Almeno un genere o un Anno massimo di uscita del Titolo");
    		return;
    	}
    	if(TxtDurata.getText().equals("")) {
    		TxtArea.setText("Scegliere una durata massima dei titoli");
    		return;
    	}
    	if(netflix.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()!=null) {
    		titoli.addAll(model.dao.listTitoliNetflixGenAnno(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(cmbAnno.getValue()),Integer.parseInt(TxtDurata.getText())));
    	}
    	else if(netflix.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()==null) {
    		titoli.addAll(model.dao.listTitoliNetflixGen(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(TxtDurata.getText())));
    	}
    	else if(netflix.isSelected() && comboGen.getValue()==null && cmbAnno.getValue()!=null) {
    		titoli.addAll(model.dao.listTitoliNetflixAnno(cmbTipo.getValue(), Integer.parseInt(cmbAnno.getValue()),Integer.parseInt(TxtDurata.getText())));
    	}
    	
    	if(prime.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()!=null) {
    		for(Titolo t : model.dao.listTitoliAmazonGenAnno(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(cmbAnno.getValue()),Integer.parseInt(TxtDurata.getText()))) {
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
    		for(Titolo t: model.dao.listTitoliAmazonAnno(cmbTipo.getValue(), Integer.parseInt(cmbAnno.getValue()),Integer.parseInt(TxtDurata.getText()))) {
    			if(!titoli.contains(t)) {
    				titoli.add(t);
    			}
    		}
    		
    	}
    	
    	
    	
    	if(disneyplus.isSelected() && comboGen.getValue()!=null && cmbAnno.getValue()!=null) {
    		for(Titolo t:model.dao.listTitoliDisneyGenAnno(cmbTipo.getValue(),comboGen.getValue(), Integer.parseInt(cmbAnno.getValue()),Integer.parseInt(TxtDurata.getText()))) {
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
    		for(Titolo t:model.dao.listTitoliDisneyAnno(cmbTipo.getValue(), Integer.parseInt(cmbAnno.getValue()),Integer.parseInt(TxtDurata.getText()))) {
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
    		return;
    	}
    	ValutMigli.setText("Valutazione Migliore: "+model.OrdinaeBest(titoli).getNome()+" ("+model.OrdinaeBest(titoli).getVoto()+")");
    	TxtTrama.setWrapText(true);
    	TxtTrama.setText(model.OrdinaeBest(titoli).getTrama());
    	
    	CmbTitoli.getItems().addAll(titoli);
    	
    }

    @FXML
    void handleAggPl(ActionEvent event) {
if(CmbTitoli.getValue()==null) {
	TxtPlaylist.setText("Scegliere un titolo da aggiungere alla playlist");
	return;
}
	Titolo t=CmbTitoli.getValue();
	
	TxtPlaylist.appendText(t.toString()+"\n");
	
	CmbTitoli.getItems().remove(t);
	
}
    

    @FXML
    void handleGen(ActionEvent event) {
    	TxtDuratTot.setText("Durata Totale");
    	TxtMarat.clear();
    	if(!netflix2.isSelected() && !prime2.isSelected() && !disneyplus2.isSelected()) {
    		TxtMarat.setText("Scegliere Almeno una Piattaforma");
    		return;	
    	}
    	
    	if(cmbGen2.getValue()==null) {
    		TxtMarat.setText("Scegliere un genere");
    		return;
    	}
    	
    	if(TxtVotomin.getText().equals("")) {
    		TxtMarat.setText("Impostare un voto minimo per i titoli");
    		return;
    	}
    	
    	if( TxtDurataMax.getText().equals("")) {
    		TxtMarat.setText("Impostare una durata massima per la Maratona");
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
    	
    	model.CreaGrafo(cmbGen2.getValue(), slNud.getValue(), slViol.getValue(), slAlc.getValue(), slPau.getValue(), Piattaforme, Integer.parseInt(TxtVotomin.getText()),Integer.parseInt(TxtDurataMax.getText()),Integer.parseInt(cmbAnno2.getValue()));
    	
    	
    	if(model.CreaCammino(Integer.parseInt(TxtDurataMax.getText()))==null) {
    		TxtMarat.setText("Impossibile Generare una Maratona a partire da tali preferenze");
    		return;
    	}
    	List<Titolo>Maratona=model.CreaCammino(Integer.parseInt(TxtDurataMax.getText()));
    	for(Titolo t :Maratona) {
    		TxtMarat.appendText(t+"\n");
    	}
    	
    	TxtDuratTot.setText("Durata Tot: "+model.calcolopeso(Maratona));
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
    }

    @FXML
    void handleResetPlay(ActionEvent event) {
TxtPlaylist.clear();
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

        

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	comboGen.getItems().addAll(model.generi);
    	cmbGen2.getItems().addAll(model.generi);
    	cmbTipo.getItems().add("Film");
    	cmbTipo.getItems().add("Series");
    	cmbAnno.getItems().add("1980");
    	cmbAnno.getItems().add("2000");
    	cmbAnno.getItems().add("2021");
    	cmbAnno2.getItems().add("1980");
    	cmbAnno2.getItems().add("2000");
    	cmbAnno2.getItems().add("2021");
    
    }

}



