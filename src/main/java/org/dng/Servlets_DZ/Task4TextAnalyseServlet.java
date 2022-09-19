package org.dng.Servlets_DZ;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Task4TextAnalysServlet", value = "/Task4TextAnalyse")
public class Task4TextAnalyseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task4TextAnalyse.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean error=false;
        String inputedText = "";
        if(request.getParameter("inputedText")!=""){
            inputedText = request.getParameter("inputedText");
        }
        else{
            error = true;
        }

        if (!error){

            //количество гласных, список гласных,
            //количество согласных, список согласных,
            // количество знаков препинания, список знаков препинания
//            int countVowels = 0;
//            List<String> vowelsList = new LinkedList<>();
//            Pattern patternVowels = Pattern.compile("[aeoiuяыуаеиоюэ]");
//            Matcher matcherVowels = patternVowels.matcher(inputedText);
//            while (matcherVowels.find()){
//                countVowels ++;
//                vowelsList.add(matcherVowels.group());
//            }
//
//            int countConsonants = 0;
//            List<String> consonantsList = new LinkedList<>();
//            Pattern  patternConsonants = Pattern.compile("[qzwsxdcrfvtgbyhnjmklpйфцчвскмпнртгшлбщдзжх]");
//            Matcher matcherConsonants = patternConsonants.matcher(inputedText);
//            while (matcherConsonants.find()){
//                countConsonants ++;
//                consonantsList.add(matcherConsonants.group());
//            }
//
//            int countPunctuationMarks = 0;
//            List<String> punctuationMarksList = new LinkedList<>();
//            Pattern patternPunctuationMarks = Pattern.compile("[,.?!-:;]");
//            Matcher matcherPunctuationMarks = patternPunctuationMarks.matcher(inputedText);
//            while (matcherVowels.find()){
//                countPunctuationMarks ++;
//                punctuationMarksList.add(matcherPunctuationMarks.group());
//            }

            StringBuilder sb = new StringBuilder();
            TextProcessingResult tr = getTextProcessingResult(inputedText,  "[aeoiuяыуаеиоюэ]");
            sb.append("Count of vowels is ");
            sb.append(tr.getCount());
            sb.append(",  ");
            sb.append(" list of vowels is ");
            sb.append(tr.symbolList.toString());

            String result = sb.toString();
            request.setAttribute("inputedText", inputedText);
            request.setAttribute("result1", result);

            //clear string buffer
            sb.setLength(0);
            tr = getTextProcessingResult(inputedText,  "[qzwsxdcrfvtgbyhnjmklpйфцчвскмпнртгшлбщдзжх]");
            sb.append("Count of consonants is ");
            sb.append(tr.getCount());
            sb.append(",  ");
            sb.append(" list of consonants is ");
            sb.append(tr.symbolList.toString());
            result = sb.toString();
            request.setAttribute("result2", result);

            //clear string buffer
            sb.setLength(0);
            tr = getTextProcessingResult(inputedText,  "[,.?!-:;]");
            sb.append("Count of PunctuationMarks is ");
            sb.append(tr.getCount());
            sb.append(",  ");
            sb.append(" list of PunctuationMarks is ");
            sb.append(tr.symbolList.toString());
            result = sb.toString();
            request.setAttribute("result3", result);


            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task4TextAnalyse.jsp");
            dispatcher.forward(request, response);
        }
        else{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Something wrong! </h1>");
            out.println("<a style=font-size: x-large href="+request.getContextPath()+">main menu</a>");
            out.println("</body></html>");
        }
    }
    public TextProcessingResult getTextProcessingResult(String inputedText, String regExp){
        int count = 0;
        List<String> symbolList = new LinkedList<>();
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputedText);
        while (matcher.find()){
            count ++;
            symbolList.add(matcher.group());
        }
        return new TextProcessingResult(count, symbolList);
    }



    static class TextProcessingResult{ //inner class
        private final int count;
        private final List<String> symbolList;

        public TextProcessingResult(int count, List<String> symbolList) {
            this.count = count;
            this.symbolList = symbolList;
        }

        public int getCount() {
            return count;
        }

        public List<String> getSimbolList() {
            return symbolList;
        }
    }
}
