package com.example.textviewelements;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView article;
    private Button addCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a las vistas
        article = findViewById(R.id.article);
        addCommentButton = findViewById(R.id.addCommentButton);

        // Configuración del botón
        addCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un diálogo para ingresar el comentario
                showCommentDialog();
            }
        });
    }

    private void showCommentDialog() {
        final EditText editTextComment = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Comment");
        builder.setView(editTextComment);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Obtener el texto del EditText
                String comment = editTextComment.getText().toString().trim();

                // Agregar el texto al TextView 'article'
                addTextToArticle(comment);
            }
        });
        builder.setNegativeButton("Cancel", null);

        builder.create().show();
    }

    private void addTextToArticle(String comment) {
        // Agregar el texto al TextView 'article'
        if (!comment.isEmpty()) {
            String currentArticleText = article.getText().toString();
            String newArticleText = currentArticleText + "\n" + comment;
            article.setText(newArticleText);
        }
    }
}

