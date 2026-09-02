import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from registration form

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String membership = request.getParameter("membership");
        String department = request.getParameter("department");
        String book = request.getParameter("book");


        // Set response type

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();


        // HTML START

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");

        out.println("<head>");

        out.println("<meta charset='UTF-8'>");

        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.println("<title>Registration Successful</title>");


        // CSS

        out.println("<style>");

        out.println("""
            
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: "Segoe UI", Arial, sans-serif;
            }

            body {

                min-height: 100vh;

                background:
                    linear-gradient(135deg, #eef2ff, #f8fafc);

                display: flex;

                justify-content: center;

                align-items: center;

                padding: 30px;
            }


            /* MAIN CARD */

            .container {

                width: 100%;

                max-width: 720px;

                background: #ffffff;

                border-radius: 22px;

                padding: 42px 50px;

                box-shadow:
                    0 20px 60px rgba(15, 23, 42, 0.12);
            }


            /* HEADER */

            .header {

                text-align: center;

                margin-bottom: 30px;
            }


            /* SUCCESS ICON */

            .success-icon {

                width: 70px;

                height: 70px;

                border-radius: 50%;

                background: #dcfce7;

                color: #16a34a;

                display: flex;

                align-items: center;

                justify-content: center;

                font-size: 36px;

                font-weight: 700;

                margin: 0 auto 18px;
            }


            .header h1 {

                font-size: 28px;

                color: #0f172a;

                margin-bottom: 8px;
            }


            .header p {

                font-size: 14px;

                color: #64748b;
            }


            /* SECTION */

            .section-title {

                font-size: 14px;

                font-weight: 700;

                color: #334155;

                text-transform: uppercase;

                letter-spacing: 0.6px;

                margin-bottom: 15px;
            }


            /* DETAILS */

            .details {

                border: 1px solid #e2e8f0;

                border-radius: 12px;

                overflow: hidden;

                background: #ffffff;
            }


            .row {

                display: flex;

                justify-content: space-between;

                align-items: center;

                gap: 20px;

                padding: 14px 16px;

                border-bottom: 1px solid #e2e8f0;
            }


            .row:last-child {

                border-bottom: none;
            }


            .label {

                color: #64748b;

                font-size: 13px;

                font-weight: 500;
            }


            .value {

                color: #0f172a;

                font-size: 13px;

                font-weight: 600;

                text-align: right;

                max-width: 60%;

                word-break: break-word;
            }


            /* ACTIVATED MESSAGE */

            .success-message {

                margin-top: 20px;

                padding: 13px;

                background: #eff6ff;

                border-radius: 10px;

                text-align: center;

                color: #1d4ed8;

                font-size: 13px;

                font-weight: 600;
            }


            /* BUTTON */

            .back-button {

                display: block;

                width: 100%;

                height: 50px;

                line-height: 50px;

                text-align: center;

                margin-top: 20px;

                border-radius: 10px;

                background:
                    linear-gradient(135deg, #2563eb, #1d4ed8);

                color: white;

                text-decoration: none;

                font-size: 15px;

                font-weight: 700;

                transition: 0.2s ease;
            }


            .back-button:hover {

                transform: translateY(-1px);

                box-shadow:
                    0 8px 20px rgba(37, 99, 235, 0.25);
            }


            /* RESPONSIVE */

            @media (max-width: 600px) {

                body {

                    padding: 15px;
                }


                .container {

                    padding: 30px 25px;

                    border-radius: 18px;
                }


                .header h1 {

                    font-size: 24px;
                }


                .row {

                    flex-direction: column;

                    align-items: flex-start;

                    gap: 5px;
                }


                .value {

                    max-width: 100%;

                    text-align: left;
                }

            }

        """);

        out.println("</style>");

        out.println("</head>");


        // BODY

        out.println("<body>");


        out.println("<div class='container'>");


        // HEADER

        out.println("<div class='header'>");


        out.println("<div class='success-icon'>");

        out.println("✓");

        out.println("</div>");


        out.println("<h1>");

        out.println("Registration Successful");

        out.println("</h1>");


        out.println("<p>");

        out.println("Your library membership has been created successfully.");

        out.println("</p>");


        out.println("</div>");


        // MEMBER INFORMATION

        out.println("<div class='section-title'>");

        out.println("Member Information");

        out.println("</div>");


        out.println("<div class='details'>");


        // NAME

        out.println("<div class='row'>");

        out.println("<span class='label'>Full Name</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(name));

        out.println("</span>");

        out.println("</div>");


        // REGISTER NUMBER

        out.println("<div class='row'>");

        out.println("<span class='label'>Register Number</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(regno));

        out.println("</span>");

        out.println("</div>");


        // EMAIL

        out.println("<div class='row'>");

        out.println("<span class='label'>Email Address</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(email));

        out.println("</span>");

        out.println("</div>");


        // PHONE

        out.println("<div class='row'>");

        out.println("<span class='label'>Phone Number</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(phone));

        out.println("</span>");

        out.println("</div>");


        // MEMBERSHIP

        out.println("<div class='row'>");

        out.println("<span class='label'>Membership Type</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(membership));

        out.println("</span>");

        out.println("</div>");


        // DEPARTMENT

        out.println("<div class='row'>");

        out.println("<span class='label'>Department</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(department));

        out.println("</span>");

        out.println("</div>");


        // BOOK / SUBJECT

        out.println("<div class='row'>");

        out.println("<span class='label'>Preferred Book / Subject</span>");

        out.println("<span class='value'>");

        out.println(escapeHtml(book));

        out.println("</span>");

        out.println("</div>");


        out.println("</div>");


        // SUCCESS MESSAGE

        out.println("<div class='success-message'>");

        out.println("✓ Library Membership Activated");

        out.println("</div>");


        // BACK BUTTON

        out.println("<a href='index.html' class='back-button'>");

        out.println("Register Another Member");

        out.println("</a>");


        out.println("</div>");


        out.println("</body>");

        out.println("</html>");
    }


    // HTML escaping

    private String escapeHtml(String value) {

        if (value == null || value.isEmpty()) {

            return "Not provided";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}