// 1. Interfaces de Chair, Sofa y CoffeeTable
interface Chair {
  assemble(): void;
}

interface Sofa {
  recline(): void;
}

interface CoffeeTable {
  putCoffee(): void;
}

// 2. Clases Concretas de muebles

// Modernos
class ModernChair implements Chair {
  assemble(): void {
    console.log('Assembling modern chair');
  }
}

class ModernSofa implements Sofa {
  recline(): void {
    console.log('Reclining modern sofa');
  }
}

class ModernCoffeeTable implements CoffeeTable {
  putCoffee(): void {
    console.log('Placing coffee on modern coffee table');
  }
}

// Victorianos
class VictorianChair implements Chair {
  assemble(): void {
    console.log('Assembling victorian chair');
  }
}

class VictorianSofa implements Sofa {
  recline(): void {
    console.log('Reclining victorian sofa');
  }
}

class VictorianCoffeeTable implements CoffeeTable {
  putCoffee(): void {
    console.log('Placing coffee on victorian coffee table');
  }
}

// Rústicos
class RusticChair implements Chair {
  assemble(): void {
    console.log('Assembling rustic chair');
  }
}

class RusticSofa implements Sofa {
  recline(): void {
    console.log('Reclining rustic sofa');
  }
}

class RusticCoffeeTable implements CoffeeTable {
  putCoffee(): void {
    console.log('Placing coffee on rustic coffee table');
  }
}

// 3. Interfaz de la Fábrica Abstracta

interface FurnitureFactory {
  createChair(): Chair;
  createSofa(): Sofa;
  createCoffeeTable(): CoffeeTable;
}

// 4. Clases Concretas de Fábricas

class ModernFurnitureFactory implements FurnitureFactory {
  createChair(): Chair {
    return new ModernChair();
  }
  createSofa(): Sofa {
    return new ModernSofa();
  }
  createCoffeeTable(): CoffeeTable {
    return new ModernCoffeeTable();
  }
}

class VictorianFurnitureFactory implements FurnitureFactory {
  createChair(): Chair {
    return new VictorianChair();
  }
  createSofa(): Sofa {
    return new VictorianSofa();
  }
  createCoffeeTable(): CoffeeTable {
    return new VictorianCoffeeTable();
  }
}

class RusticFurnitureFactory implements FurnitureFactory {
  createChair(): Chair {
    return new RusticChair();
  }
  createSofa(): Sofa {
    return new RusticSofa();
  }
  createCoffeeTable(): CoffeeTable {
    return new RusticCoffeeTable();
  }
}

// 5. Código Cliente

function main(factory: FurnitureFactory, style: string) {
  console.log(`\nCreating ${style} furniture:`);
  const chair = factory.createChair();
  const sofa = factory.createSofa();
  const coffeeTable = factory.createCoffeeTable();

  chair.assemble();
  sofa.recline();
  coffeeTable.putCoffee();
}

// Pruebas
main(new ModernFurnitureFactory(), "modern");
main(new VictorianFurnitureFactory(), "victorian");
main(new RusticFurnitureFactory(), "rustic");