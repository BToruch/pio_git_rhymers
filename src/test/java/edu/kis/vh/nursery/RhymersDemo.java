package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {

	/**
	 *
	 * Klasa RhymersDemo
	 *
	 * Metody:
	 *
	 * -main - główna metoda, utworzenie wyliczanki
	 * -Zmienne:
	 * --factory - zmienna przechowująca domyślnej wyliczanki
	 *
	 * -rhymersCounting - szkielet programu, zawiera kod testowej wyliczanki
	 * -metoda wykonuje wyliczankę dla każdej stworzonej wyliczanki i zwraca ilość odrzuconych prób
	 * -Zmienne:
	 * --rhymers - tablica wyliczanek tworzonych na bazie fabryki podanej w argumencie
	 *
	 */

	public static void main(String[] args) {
		Rhymersfactory factory = new DefaultRhymersFactory();

		rhymersCounting(factory);

	}

	private static void rhymersCounting(Rhymersfactory factory) {
		DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
				factory.getFIFORhymer(), factory.getHanoiRhymer()};

		for (int i = 1; i < 15; i++)
			for (int j = 0; j < 3; j++)
				rhymers[j].countIn(i);

		java.util.Random rn = new java.util.Random();
		for (int i = 1; i < 15; i++)
			rhymers[3].countIn(rn.nextInt(20));

		for (int i = 0; i < rhymers.length; i++) {
			while (!rhymers[i].callCheck())
				System.out.print(rhymers[i].countOut() + "  ");
			System.out.println();
		}

		// TODO: można rozbić powyższy kod na pomniejsze metody :)

		System.out.println("total rejected is "
				+ ((HanoiRhymer) rhymers[3]).reportRejected());
	}

}