package th.pigoth.exotrain

class Train(input: String) {

  private val backLocomotive = "HHHH>"
  private val connector = "::"
  private val emptyCargo = "|____|"
  private val fullCargo = "|^^^^|"
  private val headLocomotive = "<HHHH"
  private val carRepresentation = mapOf(
    'H' to headLocomotive,
    'P' to "|OOOO|",
    'C' to emptyCargo,
    'R' to "|hThT|"
  )

  private var asciiRepresentation = input.toCharArray()
    .map { carRepresentation[it] }
    .joinToString(connector)
    .replace(connector + headLocomotive, connector + backLocomotive)

  fun print(): String {
    return asciiRepresentation
  }

  fun detachEnd(): Train {
    asciiRepresentation = asciiRepresentation.replace(connector + backLocomotive, "")
    return this
  }

  fun detachHead(): Train {
    asciiRepresentation = asciiRepresentation.replace(headLocomotive + connector, "")
    return this
  }

  fun fill(): Train {
    val isFull = !asciiRepresentation.contains(emptyCargo)
    if (isFull) throw IllegalStateException()

    asciiRepresentation = asciiRepresentation.replaceFirst(emptyCargo, fullCargo)
    return this
  }

}




