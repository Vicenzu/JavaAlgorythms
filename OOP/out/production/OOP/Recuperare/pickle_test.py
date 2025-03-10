import pickle

class Persona:
	def __init__(self, nome, eta, email):
		self.nome = nome
		self.eta = eta
		self.email = email

	def __repr__(self):
		return f"Persona(nome={self.nome}, eta={self.eta}, email={self.email})"

	def __eq__(self, other):
		if not isinstance(other, Persona):
			return False

		return self.nome == other.nome and self.eta == other.eta and self.email == other.email


persona = Persona("Francesco", 20, "francescogiacob11@live.it")
print(persona)


filepath = "persona.pkl"


#SERIALIZZAZIONE
with open(filepath, "wb") as file:
	pickle.dump(persona, file)
print(f"Oggetto persona serializzato e salvato su {filepath} : {persona}")


#DESERIALIZZAZIONE
with open(filepath, "rb") as file:
	persona_caricata = pickle.load(file)
print(f"Oggetto persona deserializzato da {filepath} : {persona_caricata}")



#verifica che l'oggetto originale e quello deserializzato sono equivalenti
same = persona.__dict__ == persona_caricata.__dict__
print(f"Sono equivalenti?: {persona == persona_caricata}")