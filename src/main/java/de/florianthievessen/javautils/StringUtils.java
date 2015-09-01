package de.florianthievessen.javautils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

	private static Map<String, String> irregularNouns = new HashMap<String, String>();

	static {
		irregularNouns.put("woman", "women");
		irregularNouns.put("man", "men");
		irregularNouns.put("child", "children");
		irregularNouns.put("tooth", "teeth");
		irregularNouns.put("foot", "feet");
		irregularNouns.put("person", "people");
		irregularNouns.put("leaf", "leaves");
		irregularNouns.put("mouse", "mice");
		irregularNouns.put("goose", "geese");
		irregularNouns.put("half", "halves");
		irregularNouns.put("knife", "knives");
		irregularNouns.put("wife", "wives");
		irregularNouns.put("life", "lives");
		irregularNouns.put("elf", "elves");
		irregularNouns.put("loaf", "loaves");
		irregularNouns.put("potato", "potatoes");
		irregularNouns.put("tomato", "tomatoes");
		irregularNouns.put("cactus", "cacti");
		irregularNouns.put("focus", "foci");
		irregularNouns.put("fungus", "fungi");
		irregularNouns.put("nucleus", "nuclei");
		irregularNouns.put("syllabus", "syllabuses");
		irregularNouns.put("analysis", "analyses");
		irregularNouns.put("diagnosis", "diagnoses");
		irregularNouns.put("oasis", "oases");
		irregularNouns.put("thesis", "theses");
		irregularNouns.put("crisis", "crises");
		irregularNouns.put("phenomenon", "phenomena");
		irregularNouns.put("criterion", "criteria");
		irregularNouns.put("datum", "data");
		irregularNouns.put("sheep", "sheep");
		irregularNouns.put("fish", "fish");
		irregularNouns.put("deer", "deer");
		irregularNouns.put("species", "species");
		irregularNouns.put("aircraft", "aircraft");
		irregularNouns.put("news", "news");
		irregularNouns.put("athletics", "athletics");
		irregularNouns.put("linguistics", "linguistics");
		irregularNouns.put("darts", "darts");
		irregularNouns.put("billiards", "billiards");
		irregularNouns.put("trousers", "trousers");
		irregularNouns.put("jeans", "jeans");
		irregularNouns.put("glasses", "glasses");
	}

	public static String pluralize(String item, long count) {
		if (count > 1) {
			if (item.length() > 1 && item.substring(item.length() - 1, item.length()).equals("y")) {
				return item.substring(0, item.length() - 1).concat("ies");
			}
			if ((item.length() > 1 && item.substring(item.length() - 1, item.length()).equals("s"))
					|| (item.length() > 1 && item.substring(item.length() - 1, item.length()).equals("x"))
					|| (item.length() > 2 && item.substring(item.length() - 2, item.length()).equals("ch"))
					|| item.length() > 2 && (item.substring(item.length() - 2, item.length()).equals("sh"))) {
				return item.concat("es");
			}
			if (item.length() > 1 && item.substring(item.length() - 1, item.length()).equals("z")) {
				return item.concat("zes");
			}
			if (irregularNouns.containsKey(item)) {
				return irregularNouns.get(item);
			}
			return item + "s";
		}
		return item;
	}

}
