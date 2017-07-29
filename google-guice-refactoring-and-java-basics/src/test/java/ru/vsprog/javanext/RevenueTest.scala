import org.junit.{Test, Before}
import org.scalatest.junit.{ShouldMatchersForJUnit, JUnitSuite}
import ru.vsprog.javanext.{StubPrice, Ticket, TicketRevenue}
import scala.IllegalArgumentException

class RevenueTest extends JUnitSuite with ShouldMatchersForJUnit {
  var venueRevenue: TicketRevenue = _

  @Before def initialize() {
    venueRevenue = new TicketRevenue
  }

  @Test def zeroSalesEqualsZeroRevenue() {
    assertEquals(BigDecimal.ZERO, venueRevenue estimatTotalRevenue 0)
  }

  @Test def failIfTooManeOrTooFewTicketsAreSold() {
    evaluating { venueRevenue.estimatTotalRevenue(-1) } should produce [IllegalArgumentException]
    evaluating {venueRevenue.estimatTotalRevenue(101)} should produce [IllegalArgumentException]
  }

  @Test def fiftyDiscountTickets() {
    for (i <- 1 to 50) venueRevenue.sellTicket(new Ticket())
    for (i <- 1 to 50) venueRevenue.sellTicket(new Ticket(new StubPrice(), new BigDecimal(0.9)))
    assert(1950.0 == venueRevenue.getRevenue().doubleValue())

  }
}