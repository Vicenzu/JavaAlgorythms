class Materiale:
	def __init__(self, nome : str, quantita : int, prezzo_unitario : float):
		self._nome = nome
		self._quantita = quantita
		self._prezzo_unitario = prezzo_unitario


	def get_nome(self) -> str:
		return self._nome

	def get_quantita(self) -> int:
		return self._quantita

	def get_prezzo_unitario(self) -> float:
		return self._prezzo_unitario

	def set_nome(self, nome : str) -> None:
		self._nome = nome

	def set_quantita(self, quantita : int) -> None:
		self._quantita = quantita

	def set_prezzo_unitario(self, prezzo_unitario : float) -> None:
		self._prezzo_unitario = prezzo_unitario


	def __repr__(self):
		return f"Materiale[nome='{self._nome}'; quantità={self._quantita}; prezzo unitario={self._prezzo_unitario}]"