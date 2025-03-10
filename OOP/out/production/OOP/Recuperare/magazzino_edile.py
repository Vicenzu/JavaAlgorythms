import pickle
from materiale import Materiale
from materiale_pericoloso import MaterialePericoloso

class MagazzinoEdile:
	_filepath = "miomagazzino.dat"


	def __init__(self):
		self._magazzino = self.carica_magazzino()


	def carica_magazzino(self) -> list:
		empty_list = []
		file = None

		try:
			file = open(self._filepath, "rb")
			print(f"\n\nCaricamento magazzino da {MagazzinoEdile._filepath}")
			return pickle.load(file)
		except IOError:
			print("Errore o file non trovato. Inizializzazione magazzino vuoto.")
			return empty_list
		finally:
			if file is not None:
				file.close()


	def salva_magazzino(self) -> None:
		with open(self._filepath, "wb") as file:
			pickle.dump(self._magazzino, file)
			print(f"Magazzino salvato in {MagazzinoEdile._filepath}")


	def aggiungi_materiale(self, nome : str, quantita : int, prezzo_unitario : float):
		new_material = Materiale(nome, quantita, prezzo_unitario)
		self._magazzino.append(new_material)


	def aggiungi_materiale_pericoloso(self, nome : str, quantita : int, prezzo_unitario : float, classe_pericolo : int):
		new_dangerous_material = MaterialePericoloso(nome, quantita, prezzo_unitario, classe_pericolo)
		self._magazzino.append(new_dangerous_material)


	def visualizza_magazzino(self) -> None:
		if len(self._magazzino) == 0:
			print("Magazzino vuoto")

		else:
			for materiale in self._magazzino:
				print(materiale)








gestione_magazzino = MagazzinoEdile()
scelta : int = 0

while scelta != 5:
	print("""
                    ---Menu gestione magazzino---
                    1) Aggiungi materiale
                    2) Aggiungi materiale pericoloso
                    3) Visualizza magazzino
                    4) Salva magazzino
                    5) Salva ed esci
                    """)

	scelta = int(input("Scegli opzione: "))

	if scelta == 1:
		nome = input("Inserisci nome materiale: ")
		quantita = int(input("Inserisci quantità materiale: "))
		prezzo_unitario = float(input("Inserisci prezzo unitario materiale: "))

		gestione_magazzino.aggiungi_materiale(nome, quantita, prezzo_unitario)

	elif scelta == 2:
		nome = input("Inserisci nome materiale: ")
		quantita = int(input("Inserisci quantità materiale: "))
		prezzo_unitario = float(input("Inserisci prezzo unitario materiale: "))
		classe_pericolo = int(input("Inserisci classe pericolo materiale: "))

		gestione_magazzino.aggiungi_materiale_pericoloso(nome, quantita, prezzo_unitario, classe_pericolo)

	elif scelta == 3:
		gestione_magazzino.visualizza_magazzino()

	elif scelta == 4:
		gestione_magazzino.salva_magazzino()

	elif scelta == 5:
		gestione_magazzino.salva_magazzino()
		print("Adioos")

	else:
		print("Opzione non valida, riprova.")