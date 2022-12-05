class Pile():
	def __init__(self):
		self.p=[]
	
	def __repr__(self):
		return str(self.p)

	def empiler(self, val):
			self.p.append(val)

	def depiler(self):
			assert len(self.p)>0 , "ERREUR: pile vide"
			return self.p.pop()

	def sommet(self):
			assert len(self.p)>0 , "ERREUR: pile vide"
			return self.p[-1]

	def est_vide(self):
			return len(self.p)==0

	def taille(self):
			return len(self.p)

	def transfere(self,p2):
			assert self.taille()>0 , "ERREUR: pile de départ vide"
			val=self.depiler()
			p2.empiler(val)

	def inverser(self):
		assert self.taille()>0 , "ERREUR: pile vide"
		ptemp=Pile()
		ptemp2=Pile()
		for i in range(self.taille()):
			self.transfere(ptemp)
		for i in range(ptemp.taille()):
			ptemp.transfere(ptemp2)
		for i in range(ptemp2.taille()):
			ptemp2.transfere(self)
