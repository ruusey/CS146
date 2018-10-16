package com.ec;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CalculatorInterface extends JFrame {
	/**
	 * @author Robert Usey
	 */
	private static final long serialVersionUID = 1L;
	static JTextArea console = new JTextArea(1, 20);
	public static int WIDTH = 300;
	public static int HEIGHT = 600;

	public static void main(String[] args) {

		JFrame guiFrame = new JFrame();
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Ru's Calculator - Applets Suck");
		guiFrame.setSize(WIDTH, HEIGHT);
		guiFrame.setLocationRelativeTo(null);
		GridLayout overall = new GridLayout(5, 1);
		GridLayout layout = new GridLayout(4, 3);

		// OUR PANELS FOR
		final JPanel keyPanel = new JPanel();
		final JPanel arithmeticPanel = new JPanel();
		final JPanel scientificPanel = new JPanel();
		final JPanel consolePanel = new JPanel();
		final JPanel functionsPanel = new JPanel();

		keyPanel.setLayout(layout);

		consolePanel.add(console);

		int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		for (int i : keys) {
			JButton button = new JButton("" + i);
			keyPanel.add(button);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if (console.getText().contains("(")) {
							console.append(i + ")");

						} else {
							console.append("" + i);
						}

					} catch (Exception err) {

					}

				}
			});

		}
		String[] arithmetic = { "+", "-", "÷", "*" };
		for (String s : arithmetic) {
			JButton button = new JButton(s);
			arithmeticPanel.add(button);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						console.append(s);
					} catch (Exception err) {

					}

				}
			});
		}
		String[] operands = { "sin", "cos", "tan", "arcsin", "arccos",
				"arctan", "^", "log", "sqrt" };
		for (String s : operands) {
			JButton button = new JButton(s);
			scientificPanel.add(button);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						console.append(s + "(");
					} catch (Exception err) {

					}

				}
			});
		}

		JButton clear = new JButton("Clear");
		functionsPanel.add(clear);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					console.setText("");

				} catch (Exception err) {

				}

			}
		});

		JButton equals = new JButton("=");
		functionsPanel.add(equals);
		equals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					solve(console.getText());

				} catch (Exception err) {

				}

			}
		});

		// final JPanel options = new JPanel();
		guiFrame.setVisible(true);
		guiFrame.setLayout(overall);
		// guiFrame.setLayout(layout);
		// guiFrame.add(comboPanel, BorderLayout.NORTH);
		guiFrame.add(consolePanel);
		guiFrame.add(scientificPanel);
		guiFrame.add(arithmeticPanel);
		guiFrame.add(keyPanel);
		guiFrame.add(functionsPanel);

	}

	public static void solve(String s) {
		if (s.contains("^")) {
			String[] parts = s.split("[\\^]");
			double arg1 = Double.parseDouble(parts[0]);
			double arg2 = Double.parseDouble(parts[1]);
			writeAnswer(Math.pow(arg1, arg2));
			return;
		}
		try {
			// TO HANDLE NEGATIVE NUMBERS BECAUSE SPLITTING ON '-'
			// FOR NEGATIVE NUMBERS CREATE 3 SPLITS

			if (s.startsWith("-")) {
				String[] parts = s.split("[-+*÷]");
				int index = s.indexOf(parts[1]);
				int length = parts[1].length();
				String operand = s
						.substring(index + length, index + length + 1);
				System.out.println(operand);

				double arg1 = Double.parseDouble(parts[1]);
				double arg2 = Double.parseDouble(parts[2]);

				if (operand.equals("-")) {
					writeAnswer(arg1 - arg2);
				} else if (operand.equals("+")) {
					writeAnswer(arg1 + arg2);
				} else if (operand.equals("*")) {
					writeAnswer(arg1 * arg2);
				} else if (operand.equals("÷")) {
					writeAnswer(arg1 / arg2);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Syntax",
							"Error", JOptionPane.ERROR_MESSAGE);
					console.setText("");
				}

			} else {
				String[] parts = s.split("[-+*÷]");
				int index = s.indexOf(parts[0]);
				int length = parts[0].length();
				String operand = s
						.substring(index + length, index + length + 1);
				System.out.println(operand);

				double arg1 = Double.parseDouble(parts[0]);
				double arg2 = Double.parseDouble(parts[1]);

				if (operand.equals("-")) {
					writeAnswer(arg1 - arg2);
				} else if (operand.equals("+")) {
					writeAnswer(arg1 + arg2);
				} else if (operand.equals("*")) {
					writeAnswer(arg1 * arg2);
				} else if (operand.equals("÷")) {
					writeAnswer(arg1 / arg2);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Syntax",
							"Error", JOptionPane.ERROR_MESSAGE);
					console.setText("");
				}

			}

			// IF IS NOT BASIC ARITHMATIC
		} catch (Exception e) {
			try {
				String[] parts = s.split("[()]");
				String operand = parts[0].trim();
				double arg1 = Double.parseDouble(parts[1]);
				if (operand.equals("sin")) {
					writeAnswer(Math.sin(arg1));
				} else if (operand.equals("cos")) {
					writeAnswer(Math.cos(arg1));
				} else if (operand.equals("tan")) {
					writeAnswer(Math.tan(arg1));
				} else if (operand.equals("arcsin")) {
					writeAnswer(Math.asin(arg1));
				} else if (operand.equals("arccos")) {
					writeAnswer(Math.acos(arg1));
				} else if (operand.equals("arctan")) {
					writeAnswer(Math.atan(arg1));
				} else if (operand.equals("sqrt")) {
					writeAnswer(Math.sqrt(arg1));
				} else if (operand.equals("log")) {
					writeAnswer(Math.log(arg1));
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Syntax",
							"Error", JOptionPane.ERROR_MESSAGE);
					console.setText("");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Invalid Syntax", "Error",
						JOptionPane.ERROR_MESSAGE);
				console.setText("");
			}

		}

	}

	public static void writeAnswer(double a) {
		console.setText("" + a);
	}
}
