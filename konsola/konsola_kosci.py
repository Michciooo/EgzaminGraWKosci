import random

def Gra_w_kosci():
    poprawnosc_liczby_rzutow = False
    wynik = 0
    wylosowane_liczby = []

    while poprawnosc_liczby_rzutow == False:
        wynik = 0
        wylosowane_liczby = []
        liczba_rzutow = int(input("Ile kostek chcesz rzucić? (3,10): "))
        if liczba_rzutow < 3 or liczba_rzutow > 10:
            poprawnosc_liczby_rzutow = False
        else:
            poprawnosc_liczby_rzutow = True
            for x in range(1, liczba_rzutow + 1):
                wylosowana_liczba = random.randint(1, 6)
                print(f"Kostka {x} : {wylosowana_liczba}")
                wylosowane_liczby.append(wylosowana_liczba)

            for liczba in set(wylosowane_liczby):
                if wylosowane_liczby.count(liczba) >= 2:
                    wynik += liczba * wylosowane_liczby.count(liczba)
            print(f"Wynik : {wynik}")
            zagraj_ponownie = input("Jeszcze raz ? (t/n)")
            if zagraj_ponownie == 't':
                poprawnosc_liczby_rzutow = False
            elif zagraj_ponownie == 'n':
                poprawnosc_liczby_rzutow = True
Gra_w_kosci()

'''
************************************************
 nazwa: Gra_w_kosci
 opis: Gra w kosci polegajaca na symulacji rzutu tyloma kostkami ile uzytkownik sobie zarzyczy (3-10) i wyswietlaniu wyniku danej kolejki rzutu oraz wszystkich kolejek
 parametry: brak
 zwracany typ i opis: brak
 autor: 2137
************************************************
'''
