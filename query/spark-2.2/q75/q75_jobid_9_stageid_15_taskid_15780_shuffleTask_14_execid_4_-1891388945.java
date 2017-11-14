/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private UnsafeRow project_result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 012 */
/* 013 */   public GeneratedIterator(Object[] references) {
/* 014 */     this.references = references;
/* 015 */   }
/* 016 */
/* 017 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 018 */     partitionIndex = index;
/* 019 */     this.inputs = inputs;
/* 020 */     inputadapter_input = inputs[0];
/* 021 */     project_result = new UnsafeRow(7);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 031 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 032 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 033 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 034 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 035 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 036 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 037 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 038 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 039 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 040 */       boolean project_isNull6 = true;
/* 041 */       int project_value6 = -1;
/* 042 */
/* 043 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 044 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 045 */       if (!inputadapter_isNull2) {
/* 046 */         boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 047 */         int inputadapter_value11 = inputadapter_isNull11 ? -1 : (inputadapter_row.getInt(11));
/* 048 */         boolean project_isNull8 = inputadapter_isNull11;
/* 049 */         int project_value8 = inputadapter_value11;
/* 050 */         if (project_isNull8) {
/* 051 */           if (!false) {
/* 052 */             project_isNull8 = false;
/* 053 */             project_value8 = 0;
/* 054 */           }
/* 055 */         }
/* 056 */
/* 057 */         project_isNull6 = false; // resultCode could change nullability.
/* 058 */         project_value6 = inputadapter_value2 - project_value8;
/* 059 */
/* 060 */       }
/* 061 */       boolean project_isNull5 = project_isNull6;
/* 062 */       long project_value5 = -1L;
/* 063 */       if (!project_isNull6) {
/* 064 */         project_value5 = (long) project_value6;
/* 065 */       }
/* 066 */       boolean project_isNull11 = true;
/* 067 */       double project_value11 = -1.0;
/* 068 */
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 071 */       if (!inputadapter_isNull3) {
/* 072 */         boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 073 */         double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 074 */         boolean project_isNull13 = inputadapter_isNull12;
/* 075 */         double project_value13 = inputadapter_value12;
/* 076 */         if (project_isNull13) {
/* 077 */           if (!false) {
/* 078 */             project_isNull13 = false;
/* 079 */             project_value13 = 0.0D;
/* 080 */           }
/* 081 */         }
/* 082 */
/* 083 */         project_isNull11 = false; // resultCode could change nullability.
/* 084 */         project_value11 = inputadapter_value3 - project_value13;
/* 085 */
/* 086 */       }
/* 087 */       project_rowWriter.zeroOutNullBytes();
/* 088 */
/* 089 */       if (inputadapter_isNull8) {
/* 090 */         project_rowWriter.setNullAt(0);
/* 091 */       } else {
/* 092 */         project_rowWriter.write(0, inputadapter_value8);
/* 093 */       }
/* 094 */
/* 095 */       if (inputadapter_isNull4) {
/* 096 */         project_rowWriter.setNullAt(1);
/* 097 */       } else {
/* 098 */         project_rowWriter.write(1, inputadapter_value4);
/* 099 */       }
/* 100 */
/* 101 */       if (inputadapter_isNull5) {
/* 102 */         project_rowWriter.setNullAt(2);
/* 103 */       } else {
/* 104 */         project_rowWriter.write(2, inputadapter_value5);
/* 105 */       }
/* 106 */
/* 107 */       if (inputadapter_isNull6) {
/* 108 */         project_rowWriter.setNullAt(3);
/* 109 */       } else {
/* 110 */         project_rowWriter.write(3, inputadapter_value6);
/* 111 */       }
/* 112 */
/* 113 */       if (inputadapter_isNull7) {
/* 114 */         project_rowWriter.setNullAt(4);
/* 115 */       } else {
/* 116 */         project_rowWriter.write(4, inputadapter_value7);
/* 117 */       }
/* 118 */
/* 119 */       if (project_isNull5) {
/* 120 */         project_rowWriter.setNullAt(5);
/* 121 */       } else {
/* 122 */         project_rowWriter.write(5, project_value5);
/* 123 */       }
/* 124 */
/* 125 */       if (project_isNull11) {
/* 126 */         project_rowWriter.setNullAt(6);
/* 127 */       } else {
/* 128 */         project_rowWriter.write(6, project_value11);
/* 129 */       }
/* 130 */       append(project_result);
/* 131 */       if (shouldStop()) return;
/* 132 */     }
/* 133 */   }
/* 134 */ }
