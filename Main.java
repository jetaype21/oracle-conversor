

import javax.swing.*;

public class Main {
  public static void main(String[] args) {

    boolean cerrarApp = false;

    do {
      // Realizar el proceso principal aquí
      codigoInicial();

      // Mostrar las opciones al usuario
      int opcion = JOptionPane.showOptionDialog(null, "¿Desea continuar?",
              "Opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
              null, new String[]{"Si", "No", "Cancelar"}, null);

      switch (opcion) {
        case JOptionPane.YES_OPTION:
          // Acción para cerrar la aplicación
          JOptionPane.showMessageDialog(null, "Empezar desde cero...",
                  "Continuar", JOptionPane.INFORMATION_MESSAGE);
          break;
        case JOptionPane.NO_OPTION:
          // Acción para cancelar
          cerrarApp = true;
          break;
        case JOptionPane.CANCEL_OPTION:
          // Acción para continuar
          cerrarApp = true;
          break;
        default:
          // Acción por defecto (cerrar la aplicación)
          cerrarApp = true;
          break;
      }
    } while (!cerrarApp);

  }

  public static void codigoInicial () {
    /*Primer paso --> que CONVERSOR*/
    String[] opcionesConversor = {"Conversor de moneda", "Conversor de temperatura"};

    JComboBox<String> comboBoxOpciones = new JComboBox<>(opcionesConversor);
    JOptionPane.showMessageDialog(null, comboBoxOpciones, "Que quiere hacer hoy?", JOptionPane.PLAIN_MESSAGE);

    // Obtener la opción seleccionada
    /*
     * id 0 --> conversor de monedas
     * id 1 --> conversor de temperatura
     * */
    int opcionSeleccionada = comboBoxOpciones.getSelectedIndex();

    if (opcionSeleccionada == 0) {

      double monedas = Double.parseDouble(JOptionPane.showInputDialog("Ingrese tus monedas: "));
      String[] opcionesConversorMonedas = {"Soles a dolares", "Soles a euros", "Soles a reales", "Dolares a soles", "Euros a soles"};
      JComboBox<String> comboMonedas = new JComboBox<>(opcionesConversorMonedas);
      JOptionPane.showMessageDialog(null, comboMonedas, "Seleccione una opcion: ", JOptionPane.PLAIN_MESSAGE);
      int opcionMonedas = comboMonedas.getSelectedIndex();

      String monedaConvertido = convertirMonedas(opcionMonedas, monedas);
      JOptionPane.showMessageDialog(null, monedaConvertido);

    } else if (opcionSeleccionada == 1) {
      double grados = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura: "));
      String[] opcionesTemperaturas = {"Celsius a Kelvin", "Kevlin a Celsius"};
      JComboBox<String> comboTemperatuas = new JComboBox<>(opcionesTemperaturas);
      JOptionPane.showMessageDialog(null, comboTemperatuas, "Seleccione una opcion: ", JOptionPane.PLAIN_MESSAGE);
      int opcionTemperatura = comboTemperatuas.getSelectedIndex();

      String gradosConvertido = convertirGrados(opcionTemperatura, grados);
      JOptionPane.showMessageDialog(null, gradosConvertido);
    }
  }

  public static String convertirMonedas(int opcion, double monedas) {
    /*
     *  0 --> sol a dol
     *  1 --> sol a euro
     *  2 --> sol a real
     *  3 --> dol a sol
     *  4 --> eu a sol
     * */
    switch (opcion) {
      case 0 -> {
        return "Tus monedas en dolares son: " + monedas * 0.28;
      }
      case 1 -> {
        return "Tus monedas en euros son: " + monedas * 0.25;
      }
      case 2 -> {
        return "Tus monedas en reales son: " + monedas * 1.32;
      }
      case 3 -> {
        return "Tus monedas en soles son: " + monedas * 3.62;
      }
      case 4 -> {
        return "Tus monedas en soles son: " + monedas * 3.96;
      }
    }
    return "debe retornar algo";
  }

  public static String convertirGrados(int opcion, double grados) {
    /*
     *  0 --> celsius a kelvin
     *  1 --> kelvin a celcius
     * */
    switch (opcion) {
      case 0 -> {
        return "Tu temperatura en kelvin es: " + ( grados + 273.15);
      }
      case 1 -> {
        return "Tu temperatura en celcius es: " +  (grados - 273.15);
      }
    }
    return "debe retornar algo";
  }
}
