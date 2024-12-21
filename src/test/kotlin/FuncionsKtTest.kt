import org.junit.jupiter.api.Test
import org.example.*
import org.junit.jupiter.api.Assertions.*
 class FuncionsKtTest {


  @Test
  fun checkSumaValue() {
   val expected=10.0f
   assertEquals(expected,suma(5.0f,5.0f))

   val expected2=50.0f
    assertEquals(expected2,suma(50.0f,0.0f))
  }

  @Test
  fun checkSumaNegativeValue() {
   val expected=-100088887.0f
   assertEquals(expected,suma(-99999999.0f,-88888.0f))

  }

  @Test
  fun checkSumaDataType() {
   assertTrue(suma(5.0f,5.0f) is Float)
  }

  @Test
  fun checkSumaNotNull() {
   assertNotNull(suma(1000000.0f,1000000.0f))
  }

  @Test
  fun checkRestaValue() {
   val expected=0.0f
   assertEquals(expected,resta(5.0f,5.0f))

   val expected2=-5.0f
   assertEquals(expected2,resta(0.0f,5.0f))
  }

  @Test
  fun checkRestaDataType() {
   assertTrue(resta(5.0f,5.0f) is Float)
  }

  @Test
  fun checkMultiplicacioValue() {
   val expected=50.0f
   assertEquals(expected,multiplicacio(5.0f,10.0f))

   val expected2=530.25f
   assertEquals(expected2,multiplicacio(10.5f,50.5f))
  }

  @Test
  fun checkMultiplicacioNegativeValue() {
   val expected=888791112.0f
   assertEquals(expected,multiplicacio(-99999.0f,-8888.0f))
  }

  @Test
  fun checkMultiplicacioDataType() {
   assertTrue(multiplicacio(5.0f,5.0f) is Float)
  }

  @Test
  fun checkMultiplicacioNotNull() {
   assertNotNull(suma(1000000.0f,1000000.0f))
  }

  @Test
  fun checkDivisioValue() {
   val expected=2.0f
   assertEquals(expected,divisio(4.0f,2.0f))

   val expected2=2.55f
   assertEquals(expected2,divisio(25.5f,10.0f))
  }

  @Test
  fun checkDivisioNegativeValue() {
   val expected=166.83183f
   assertEquals(expected,divisio(-55555.0f,-333.0f))
  }

  @Test
  fun checkDivisioValueNotEquals() {
   val expected=0.0f
   assertNotEquals(expected,divisio(10.0f,0.0f))

   val expected2=10.0f
   assertNotEquals(expected2,divisio(10.0f,0.0f))
  }

  @Test
  fun checkDivisioDataType() {
   assertTrue(divisio(4.0f,2.0f) is Float)
  }

  @Test
  fun checkQuadratValue() {
   val expected=4
   assertEquals(expected,quadrat(2))
  }

  @Test
  fun checkQuadratDataType() {
   assertTrue(quadrat(2) is Int)
  }

  @Test
  fun checkOperarSumaValue() {
   val expected=25.0f
   assertEquals(expected,operar(5.0f,20.0f,::suma))
  }

  @Test
  fun checkOperarSumaDataType() {
   assertTrue(operar(5.0f,20.0f,::suma) is Float)
  }

  @Test
  fun checkOperarRestaValue() {
   val expected=-5.5f
   assertEquals(expected,operar(25.0f,30.5f,::resta))
  }

  @Test
  fun checkOperarRestaDataType() {
   assertTrue(operar(-500.4f,20000.9f,::resta) is Float)
  }

  @Test
  fun checkOperarMultiplicacioValue() {
   val expected=55.65f
   assertEquals(expected,operar(10.5f,5.3f,::multiplicacio))
  }

  @Test
  fun checkOperarMultiplicacioDataType() {
   assertTrue(operar(-50000.987f,30000.456f,::multiplicacio) is Float)
  }

  @Test
  fun checkOperarDivisioValue() {
   val expected=50.00f
   assertEquals(expected,operar(50.0f,1.0f,::multiplicacio))
  }

  @Test
  fun checkOperarDivisioDataType() {
   assertTrue(operar(-50000.987f,30.456f,::divisio) is Float)
  }

  @Test
  fun checkOperarQuadratValue() {
   val expected=2500
   assertEquals(expected,operar(50,::quadrat))
  }

  @Test
  fun checkOperarQuadratDataType() {
   assertTrue(operar(50,::quadrat) is Int)
  }

  @Test
  fun checkSumaOperarDosNumerosValue() {
   var entradaUsuari= arrayOf(-50.0f,-80.0f)
   var operacio="suma"
   val expected=arrayOf(-50.0f,-80.0f,-130.0f)
   assertArrayEquals(expected, operarDosNumeros(entradaUsuari,operacio))
  }

  @Test
  fun checkRestaOperarDosNumerosValue() {
   var entradaUsuari= arrayOf(-50.0f,-80.0f)
   var operacio="resta"
   val expected=arrayOf(-50.0f,-80.0f,30.0f)
   assertArrayEquals(expected, operarDosNumeros(entradaUsuari,operacio))
  }

  @Test
  fun checkMultiplicacioOperarDosNumerosNull() {
   var entradaUsuari= arrayOf(-5999.9999f,88888.777f)
   var operacio="multiplicacio"
   assertNotNull(operarDosNumeros(entradaUsuari,operacio))
  }

  @Test
  fun checkDivisioOperarDosNumerosNull() {
   var entradaUsuari= arrayOf(99995876999.9999f,0.0f)
   var operacio="divisio"
   assertNotNull(operarDosNumeros(entradaUsuari,operacio))
  }

 }





