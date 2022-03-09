package datastruct;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	MyUnsortedList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = MyUnsortedList.of();
	}

	@Test
	public void testEmptyVide () {
		boolean condition = list.isEmpty();
		assertTrue("La liste n'est pas vide alors qu'elle le devrait", condition);
	}

	@Test
	public void testEmptyPlein () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(5);
		list = MyUnsortedList.of(liste);
		boolean condition = list.isEmpty();
		assertFalse("La liste est affiché comme vide alors qu'elle ne l'est pas", condition);
	}

	@Test
	public void testSize0List() {
		int size = list.size();
		assertEquals("Je m'attends à ce que la chaine soit égale à 0",0,size);	
	}

	@Test
	public void testSize6List() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(5);
		liste.add(5);
		liste.add(5);
		liste.add(5);
		liste.add(5);
		liste.add(5);
		list = MyUnsortedList.of(liste);
		int size = list.size();
		assertEquals("La chaine à une taille différente de 6",6,size);
	}

	@Test
	public void testPop() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		assertEquals("Le premier élément n'est pas celui retourné",1,(int)list.pop());
	}

	@Test(expected = EmptyListException.class)
	public void testPopError(){
		list.pop();
	}

	@Test
	public void testPopLast() {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		assertEquals("Le premier élément n'est pas celui retourné",3,(int)list.popLast());
	}

	@Test(expected = EmptyListException.class)
	public void testPopLastError(){
		list.popLast();
	}

	@Test
	public void testPrepend () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		list.prepend(0);
		assertEquals("La première valeur doit etre égale à 0",0,(int)list.pop());	
	}
	
	@Test
	public void testAppend () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		list.append(4);
		assertEquals("La dernière valeur est supposé être 4",4,(int)list.popLast());
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveError () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		list.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveErrorSup () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		list.remove(5);
	}
	
	@Test
	public void testRemove1 () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		assertEquals("Le premier élément n'est pas celui là",1,(int)list.remove(0));
	}
	
	@Test
	public void testRemove3 () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		assertEquals("Le dernier élément n'est pas celui là",3,(int)list.remove(2));
	}
	
	@Test
	public void testRemove () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		assertEquals("Le dernier élément n'est pas celui là",2,(int)list.remove(1));
	}
	
	@Test
	public void testRemoveSize () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		assertEquals("le retour n'est pas le bon",3,(int)list.popLast());
		assertEquals("le retour n'est pas le bon",2,(int)list.popLast());
		assertEquals("La nouvelle taille n'est pas bonne",1,list.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertError() {
		list.insert(1,-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertErrorSup() {
		list.insert(1,9);
	}
	
	@Test
	public void testInsert0 () {
		list.insert(1, 0);
		assertEquals("Le premier élément n'est pas celui là",1,(int)list.remove(0));
	}
	
	@Test
	public void testInsert () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		list.insert(4, 0);
		assertEquals("le premier élément est supposé etre 4",4,(int)list.remove(0));
	}
	
	@Test
	public void testInsertNvlleSize () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		list.insert(4, 0);
		assertEquals("la nouvelle taille est supposé être 4",4,list.size());
	}
	
	@Test
	public void testEquals () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(liste);
		assertTrue("Les deux listes auraient du être égale",list.equals(list2));
	}
	
	@Test
	public void testEqualsDiff () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		liste.add(4);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(liste);
		assertFalse("Les deux listes n'auraient ne devrait pas être égale",list.equals(list2));
	}
	
	@Test
	public void testEqualsDiff2 () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		String s = new String();
		assertFalse("Les deux listes ne sont pas de différent type",list.equals(s));
	}
	
	@Test
	public void testEqualsDiff3 () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		MyUnsortedList<String> list2 = MyUnsortedList.of("a","b","c");
		assertFalse("Les deux listes n'auraient ne devrait pas être égale",list.equals(list2));
	}
	
	@Test
	public void testEqualsDiff4 () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		MyUnsortedList<Integer> list2 = MyUnsortedList.of(4,5,6);
		assertFalse("Les deux listes n'auraient ne devrait pas être égale",list.equals(list2));
	}
	
	@Test
	public void testEqualsDiff5 () {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		list = MyUnsortedList.of(liste);
		String s = null;
		assertFalse("Les deux listes n'auraient ne devrait pas être égale",list.equals(s));
	}
	
	@After
	public void tearDown() throws Exception {

	}

}
