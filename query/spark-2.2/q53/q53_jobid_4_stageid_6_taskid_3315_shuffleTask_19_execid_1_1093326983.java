/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */   private UnsafeRow project_result;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 016 */
/* 017 */   public GeneratedIterator(Object[] references) {
/* 018 */     this.references = references;
/* 019 */   }
/* 020 */
/* 021 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 022 */     partitionIndex = index;
/* 023 */     this.inputs = inputs;
/* 024 */     inputadapter_input = inputs[0];
/* 025 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 026 */     filter_result = new UnsafeRow(4);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 029 */     project_result = new UnsafeRow(3);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 039 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 040 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 041 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 042 */
/* 043 */       boolean filter_isNull = true;
/* 044 */       boolean filter_value = false;
/* 045 */
/* 046 */       boolean filter_isNull1 = true;
/* 047 */       double filter_value1 = -1.0;
/* 048 */
/* 049 */       boolean filter_isNull2 = true;
/* 050 */       boolean filter_value2 = false;
/* 051 */
/* 052 */       if (!inputadapter_isNull3) {
/* 053 */         filter_isNull2 = false; // resultCode could change nullability.
/* 054 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value3, 0.0D) > 0;
/* 055 */
/* 056 */       }
/* 057 */       if (!filter_isNull2 && filter_value2) {
/* 058 */         boolean filter_isNull5 = false;
/* 059 */         double filter_value5 = -1.0;
/* 060 */         if (inputadapter_isNull3 || inputadapter_value3 == 0) {
/* 061 */           filter_isNull5 = true;
/* 062 */         } else {
/* 063 */           boolean filter_isNull7 = true;
/* 064 */           double filter_value7 = -1.0;
/* 065 */
/* 066 */           if (!inputadapter_isNull1) {
/* 067 */             if (!inputadapter_isNull3) {
/* 068 */               filter_isNull7 = false; // resultCode could change nullability.
/* 069 */               filter_value7 = inputadapter_value1 - inputadapter_value3;
/* 070 */
/* 071 */             }
/* 072 */
/* 073 */           }
/* 074 */           boolean filter_isNull6 = filter_isNull7;
/* 075 */           double filter_value6 = -1.0;
/* 076 */
/* 077 */           if (!filter_isNull7) {
/* 078 */             filter_value6 = (double)(java.lang.Math.abs(filter_value7));
/* 079 */           }
/* 080 */           if (filter_isNull6) {
/* 081 */             filter_isNull5 = true;
/* 082 */           } else {
/* 083 */             filter_value5 = (double)(filter_value6 / inputadapter_value3);
/* 084 */           }
/* 085 */         }
/* 086 */         filter_isNull1 = filter_isNull5;
/* 087 */         filter_value1 = filter_value5;
/* 088 */       }
/* 089 */
/* 090 */       else {
/* 091 */         final double filter_value11 = -1.0;
/* 092 */         filter_isNull1 = true;
/* 093 */         filter_value1 = filter_value11;
/* 094 */       }
/* 095 */       if (!filter_isNull1) {
/* 096 */         filter_isNull = false; // resultCode could change nullability.
/* 097 */         filter_value = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value1, 0.1D) > 0;
/* 098 */
/* 099 */       }
/* 100 */       if (filter_isNull || !filter_value) continue;
/* 101 */
/* 102 */       filter_numOutputRows.add(1);
/* 103 */
/* 104 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 105 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 106 */       project_rowWriter.zeroOutNullBytes();
/* 107 */
/* 108 */       if (inputadapter_isNull) {
/* 109 */         project_rowWriter.setNullAt(0);
/* 110 */       } else {
/* 111 */         project_rowWriter.write(0, inputadapter_value);
/* 112 */       }
/* 113 */
/* 114 */       if (inputadapter_isNull1) {
/* 115 */         project_rowWriter.setNullAt(1);
/* 116 */       } else {
/* 117 */         project_rowWriter.write(1, inputadapter_value1);
/* 118 */       }
/* 119 */
/* 120 */       if (inputadapter_isNull3) {
/* 121 */         project_rowWriter.setNullAt(2);
/* 122 */       } else {
/* 123 */         project_rowWriter.write(2, inputadapter_value3);
/* 124 */       }
/* 125 */       append(project_result);
/* 126 */       if (shouldStop()) return;
/* 127 */     }
/* 128 */   }
/* 129 */ }
