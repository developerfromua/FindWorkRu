package com.rsoftware.findworkru.model.PdfUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;

import androidx.core.content.FileProvider;

import com.rsoftware.findworkru.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfGenerator {
    private OutputStream os;
    public Uri createPdf(Context context, String name, String surname, String middle_name, String wanted_vacancy, String wanted_salary, String business, String schedule, String phone, String email, String city, String citizenship, String sex, String education, String work_exp, String educationInstitution, String factuality, String educationSpeciality, String yearEndingEducation, String educationForm, String resumeSkills) {
        int pageWidth = 1200;
        int pageHeight = 1350;
        PdfDocument document = new PdfDocument();
        Paint paint = new Paint();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pageWidth,pageHeight,1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        paint.setColor(Color.BLACK);
        paint.setTextSize(35f);
        canvas.drawText("Резюме", pageWidth/2, 50, paint);
        paint.setTextSize(20f);
        canvas.drawText("ФИО: " + name + " " + surname + " " + middle_name,40,100, paint);
        canvas.drawText("Желаемая должность: " + wanted_vacancy,40,150, paint);
        canvas.drawText("Город: " + city,40,200, paint);
        canvas.drawText("Телефон: " + phone,40,250, paint);
        canvas.drawText("Email: " + email,40,300, paint);
        paint.setTextSize(35f);
        canvas.drawText("Пожелания по вакансии",40,350, paint);
        paint.setTextSize(20f);
        canvas.drawText("Зарплата: " + wanted_salary,40,400, paint);
        canvas.drawText("Занятость: " + business,40,450, paint);
        canvas.drawText("График: " + schedule,40,500, paint);
        paint.setTextSize(35f);
        canvas.drawText("О себе",40,550, paint);
        paint.setTextSize(20f);
        canvas.drawText("Гражданство: " + citizenship,40,600, paint);
        canvas.drawText("Пол: " + sex,40,650, paint);
        canvas.drawText("Образование: " + education,40,700, paint);
        paint.setTextSize(35f);
        canvas.drawText("Опыт работы",40,750, paint);
        paint.setTextSize(20f);
        canvas.drawText(work_exp,40,800, paint);
        paint.setTextSize(35f);
        canvas.drawText("Образование",40,850, paint);
        paint.setTextSize(20f);
        canvas.drawText("Учебное заведение: " + educationInstitution,40,900, paint);
        canvas.drawText("Факультет: " + factuality,40,950, paint);
        canvas.drawText("Специальность: " + educationSpeciality,40,1000, paint);
        canvas.drawText("Год окончания: " + yearEndingEducation,40,1050, paint);
        canvas.drawText("Форма обучения: " + educationForm,40,1100, paint);
        paint.setTextSize(35f);
        canvas.drawText("Навыки, способоности",40,1150, paint);
        paint.setTextSize(20f);
        canvas.drawText(resumeSkills,40,1200, paint);

        document.finishPage(page);

        try {
            File pdfDirPath = new File(context.getApplicationContext().getFilesDir(), "pdfs");
            pdfDirPath.mkdirs();
            File file = new File(pdfDirPath, "cv.pdf");
            Uri contentUri = FileProvider.getUriForFile(context.getApplicationContext(),
                    BuildConfig.APPLICATION_ID + ".provider", file);
            os = new FileOutputStream(file);
            document.writeTo(os);
            document.close();
            os.close();

           return contentUri;
        } catch (IOException e) {
            throw new RuntimeException("Error generating file", e);
        }
    }
}
