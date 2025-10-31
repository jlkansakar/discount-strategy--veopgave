# Strategy Pattern Øvelse

En refaktoriseringsøvelse hvor man skal transformere tæt-koblet rabatlogik med
Strategy Pattern.

Omskriv den nuværende `ShoppingCart` klasse til at bruge Strategy Pattern
i stedet for at have rabatlogik direkte indlejret.

`ShoppingCart` klassen indeholder hardcoded rabatlogik ved brug af switch
statements.  Dette overtræder Open/Closed-princippet og gør det svært at
tilføje nye rabattyper eller teste rabatlogik uafhængigt.

**Din Opgave**:
1. Opret konkrete implementeringer af `DiscountStrategy` interfacet
2. Omskriv `ShoppingCart` til at bruge strategy objekter i stedet for
   `applyDiscount()` metoden
3. Opdater `Main` klassen til at demonstrere runtime strategy skift

## Hvad er Open/Closed-princippet?

Software enheder (klasser, moduler, funktioner) skal være åbne for udvidelse,
men lukkede for modifikation. Det betyder, at du skal kunne tilføje ny
funktionalitet uden at ændre eksisterende kode.

## Strategy Pattern Komponenter

### 1. Strategy Interface
```java
public interface DiscountStrategy {
    double applyDiscount(double price);
    String getStrategyName();
}
```

### 2. Konkrete Strategies (skal implementeres)

Du skal oprette disse konkrete strategy klasser:

- **PercentageDiscount**: Anvender en procentuel rabat (f.eks. 10% rabat)
- **FixedAmountDiscount**: Trækker et fast beløb fra (minimum $0)
- **LoyaltyPointsDiscount**: Kunde optjener og indløser loyalitetspoint til
  rabatter

Hver skal implementere `DiscountStrategy` interfacet og indeholde den specifikke
rabatberegningslogik der i øjeblikket findes i `ShoppingCart.applyDiscount()`
metoden.

### 3. Kontekst-klasse

Med "kontekst" menes der den klasse som benytter en strategy, og ikke selve
strategy'en. Det er i vores tilfælde `ShoppingCart` der er konteksten. Det
gælder for konteksten i Strategy Pattern at den...

- vedligeholder en reference til et strategy-objekt
- Delegerer arbejde til strategien i stedet for at implementere algoritmen
  direkte
- Tillader strategy skift ved runtime uden at ændre kontekstens kode
- Leverer interfacet mellem klienten og strategien

I vores indkøbskurv eksempel fungerer `ShoppingCart` klassen som konteksten.
Den har i øjeblikket rabatlogik blandet direkte ind i sin kode, men bør
omskrives til at bruge Strategy mønsteret:

Før Strategy Pattern (nuværende tilstand):

```java
public class ShoppingCart {
    // Rabatlogik er blandet ind i kontekstklassen
    public double applyDiscount(double price, String discountType, double discountValue) {
        switch (discountType) {
            case "percentage": return price * (1 - discountValue / 100);
            case "fixed": return Math.max(0, price - discountValue);
            default: return price;
        }
    }
}
```

Efter Strategy Pattern (mål):

```java
public class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double calculateTotal() {
        return discountStrategy.applyDiscount(totalPrice);
    }
}
```

Konteksten bliver meget renere og fokuseret på sit primære ansvar (håndtering
af indkøbskurven) mens den delegerer rabatberegninger til strategy-objekter.

## Vigtige Læringspunkter

### Strategy Pattern Fordele
1. **Runtime Algoritmevalg**: Skift rabattyper uden at ændre kurvekode
2. **Open/Closed Princip**: Nemt at tilføje nye rabatstrategier
3. **Enkelt Ansvar**: Hver strategy håndterer én rabattype
4. **Testbarhed**: Strategier kan testes uafhængigt af deres kontekst

## Trin-for-trin instruktioner

### Trin 1: analyser Nuværende Kode

Kør den nuværende `Main` klasse for at se hvordan rabatlogik er tæt koblet
med `ShoppingCart` klassen.

### Trin 2: Opret konkrete strategy klasser

1. Opret `PercentageDiscount.java` - implementer procentbaserede rabatter
2. Opret `FixedAmountDiscount.java` - implementer faste beløbsrabatter
3. Opret `LoyaltyPointsDiscount.java` - implementer loyalitetspoint system

### Trin 3: Omskriv shoppingCart

1. Fjern `applyDiscount()` metoden fra `ShoppingCart`
2. Tilføj et `DiscountStrategy` felt og setter metode
3. Opdater `calculateTotal()` til at delegere til strategien
4. Erstat hardcodede rabatkald med strategy-objekter

### Trin 5: Test din løsning

Kør den omskrevne kode og verificer at:
- Alle rabattyper virker korrekt
- Strategier kan skiftes ved runtime
- `ShoppingCart` klassen er nu kun fokuseret på kurvehåndtering

Skriv en test for hver strategy-objekt! Brug AI om nødvendigt.

## Udvidelsesøvelser

Når du har gennemført den grundlæggende omskrivning:

1. **Tilføj Nye Strategier**: Studenterabat, sæsonrabat, køb-en-få-en
2. **Strategy Kombination**: Anvend flere rabatter eller vælg den bedste
3. **Konfiguration**: Indlæs rabatregler fra en properties fil
