package giss.mad.itinerario.util;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class TratamientoFuentesJava {

    private TratamientoFuentesJava() {

    }
    public static String lookupVarNameOfClassMethod(final Tarea testClass, final String classNameSearched) {
        String varNameOfClassMethod = null;
        boolean foundInvocation = false;
        int i = 0;
        while (!foundInvocation && i < testClass.getMemberDeclarations().size()) {
            Map<String, String> memberDeclararion = testClass.getMemberDeclarations().get(i++);
            String classnameOfVar = memberDeclararion.entrySet().iterator().next().getKey();
            String varname = memberDeclararion.get(classnameOfVar);
            if (classNameSearched.contentEquals(classnameOfVar)) {
                foundInvocation = true;
                varNameOfClassMethod = varname;
            }
        }
        return varNameOfClassMethod;
    }
    public static Tarea filterOnlyPackages(final Tarea rootSinFiltrar, final String packageName,
                                                 final String className) {
        Tarea rootFiltered = new Tarea();
        rootFiltered.setTest(rootSinFiltrar.getTest());
        rootFiltered.setContents(rootSinFiltrar.getContents());
        rootFiltered.setFolderName(rootSinFiltrar.getFolderName());
        rootFiltered.setLevel(rootSinFiltrar.getLevel());
        rootFiltered.setByteArrayCompressed(rootSinFiltrar.getByteArrayCompressed());
        List<Tarea> listAcumuladas = new ArrayList<>();
        recursiveLookupPackages(rootSinFiltrar, packageName, className, listAcumuladas);
        rootFiltered.setChildren(new ArrayList<>());
        rootFiltered.getChildren().addAll(listAcumuladas);
        return rootFiltered;
    }

    public static void recursiveLookupPackages(final Tarea root, final String packageNamPattern,
                                                final String classNamePattern, final List<Tarea> listAcumuladas) {
        if (root.getLevel().contentEquals(Tarea.TIPO_PACKAGE)
                && ("*".contentEquals(packageNamPattern) || packageNamPattern.contentEquals(root.getPackageName()))) {
            listAcumuladas.add(root);
        } else {
            List<Tarea> children = root.getChildren() == null ? new ArrayList<>() : root.getChildren();
            children.forEach((child) -> {
                if (child.getLevel().contentEquals(Tarea.TIPO_PACKAGE)
                        && ("*".contentEquals(packageNamPattern)
                        || packageNamPattern.contentEquals(root.getPackageName()))) {
                    listAcumuladas.add(child);
                } else {
                    recursiveLookupPackages(child, packageNamPattern, classNamePattern, listAcumuladas);
                }
            });
        }
    }


}
