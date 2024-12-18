import org.junit.jupiter.api.Test
import org.example.*
import org.junit.jupiter.api.Assertions.*
 class FuncionsKtTest {


  @Test
  fun checkTriarOpcioMenu() {
   val expected = 1
   val opcioMenu="1"
   assertEquals(expected,triarOpcioMenu(nMin=0,nMax=1))
  }

  @Test
  fun checkSumaValue() {
   val expected=10.0f
   assertEquals(expected,suma(5.0f,5.0f))
  }

  @Test
  fun checkSumaDataType() {
   assertTrue(suma(5.0f,5.0f) is Float)
  }

  @Test
  fun checkRestaValue() {
   val expected=0.0f
   assertEquals(expected,resta(5.0f,5.0f))
  }

  @Test
  fun checkMultiplicacioValue() {
   val expected=50.0f
   assertEquals(expected,multiplicacio(5.0f,10.0f))
  }

  @Test
  fun checkDivisioValue() {
   val expected=2.0f
   assertEquals(expected,divisio(4.0f,2.0f))
  }

  @Test
  fun checkQuadratValue() {
   val expected=4
   assertEquals(expected,quadrat(2))
  }




 }





