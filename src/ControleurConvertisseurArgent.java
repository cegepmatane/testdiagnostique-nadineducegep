
public class ControleurConvertisseurArgent 
{
	private VueConvertisseurArgent vue = null;
	private MontantArgent montantArgent = null;
	
	public ControleurConvertisseurArgent()
	{
		montantArgent = new MontantArgent();
		vue = new VueConvertisseurArgent(this, this.montantArgent);
		// new Vue(instanceControleur, instanceModele)
	}
	
	public void convertirDevise()
	{
		// Demande les inputs a la vue
		vue.getMontant();
		System.out.println("Le montant inscrit dans le modele est " + this.montantArgent.getMontantOriginal());
		String devise = vue.getDevise();
		
		// Le controleur effectue le traitement
		float montantConverti = 0;
		if(devise.compareTo("USD") == 0) // usd == devise
		{
			montantConverti = montantArgent.getMontantOriginal() * TestDiagnostique.TAUX_CAD_VERS_USD;
		}
		else if(devise.compareTo("EUR") == 0) // eur == devise
		{
			montantConverti = montantArgent.getMontantOriginal() * TestDiagnostique.TAUX_CAD_VERS_EURO;						
		}
		else if(devise.compareTo("BTC") == 0) // btc == devise
		{
			montantConverti = montantArgent.getMontantOriginal() * TestDiagnostique.TAUX_CAD_VERS_BTC;												
		}
		System.out.println("Le montant converti est " + montantConverti);
		
		montantArgent.setMontantConverti(montantConverti);
	
		// Le controleur demande a la vue d'afficher le traitement
		vue.afficherMontantConverti();
	}
	
}
