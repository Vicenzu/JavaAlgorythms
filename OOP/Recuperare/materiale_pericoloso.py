from materiale import Materiale

class MaterialePericoloso(Materiale):
	def __init__(self, nome: str, quantita: int, prezzo_unitario: float, classe_pericolo : int):
		super().__init__(nome, quantita, prezzo_unitario)
		self._classe_pericolo = classe_pericolo

	def __repr__(self):
		return f"Materiale[nome='{self._nome}'; quantità={self._quantita}; prezzo unitario={self._prezzo_unitario}; classe pericolo={self._classe_pericolo}]"