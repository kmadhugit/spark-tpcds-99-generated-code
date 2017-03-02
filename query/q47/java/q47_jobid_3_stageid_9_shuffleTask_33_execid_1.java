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
/* 026 */     filter_result = new UnsafeRow(10);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 128);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 10);
/* 029 */     project_result = new UnsafeRow(9);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 039 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 040 */
/* 041 */       if (!(!(inputadapter_isNull9))) continue;
/* 042 */
/* 043 */       boolean filter_isNull2 = false;
/* 044 */
/* 045 */       boolean filter_value2 = false;
/* 046 */       filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value9, 0.0D) > 0;
/* 047 */       if (!filter_value2) continue;
/* 048 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 049 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 050 */
/* 051 */       boolean filter_isNull5 = true;
/* 052 */       boolean filter_value5 = false;
/* 053 */
/* 054 */       boolean filter_isNull6 = true;
/* 055 */       double filter_value6 = -1.0;
/* 056 */
/* 057 */       boolean filter_isNull7 = false;
/* 058 */
/* 059 */       boolean filter_value7 = false;
/* 060 */       filter_value7 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value9, 0.0D) > 0;
/* 061 */       if (!false && filter_value7) {
/* 062 */         boolean filter_isNull10 = false;
/* 063 */         double filter_value10 = -1.0;
/* 064 */         if (inputadapter_isNull9 || inputadapter_value9 == 0) {
/* 065 */           filter_isNull10 = true;
/* 066 */         } else {
/* 067 */           boolean filter_isNull12 = true;
/* 068 */           double filter_value12 = -1.0;
/* 069 */
/* 070 */           if (!inputadapter_isNull6) {
/* 071 */             filter_isNull12 = false; // resultCode could change nullability.
/* 072 */             filter_value12 = inputadapter_value6 - inputadapter_value9;
/* 073 */
/* 074 */           }
/* 075 */           boolean filter_isNull11 = filter_isNull12;
/* 076 */           double filter_value11 = -1.0;
/* 077 */
/* 078 */           if (!filter_isNull12) {
/* 079 */             filter_value11 = (double)(java.lang.Math.abs(filter_value12));
/* 080 */           }
/* 081 */           if (filter_isNull11) {
/* 082 */             filter_isNull10 = true;
/* 083 */           } else {
/* 084 */             filter_value10 = (double)(filter_value11 / inputadapter_value9);
/* 085 */           }
/* 086 */         }
/* 087 */         filter_isNull6 = filter_isNull10;
/* 088 */         filter_value6 = filter_value10;
/* 089 */       }
/* 090 */
/* 091 */       else {
/* 092 */         final double filter_value16 = -1.0;
/* 093 */         filter_isNull6 = true;
/* 094 */         filter_value6 = filter_value16;
/* 095 */       }
/* 096 */       if (!filter_isNull6) {
/* 097 */         filter_isNull5 = false; // resultCode could change nullability.
/* 098 */         filter_value5 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value6, 0.1D) > 0;
/* 099 */
/* 100 */       }
/* 101 */       if (filter_isNull5 || !filter_value5) continue;
/* 102 */
/* 103 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 104 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 105 */
/* 106 */       if (!(!(inputadapter_isNull8))) continue;
/* 107 */
/* 108 */       filter_numOutputRows.add(1);
/* 109 */
/* 110 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 111 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 112 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 113 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 114 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 115 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 116 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 117 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 118 */       int inputadapter_value4 = inputadapter_row.getInt(4);
/* 119 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 120 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 121 */       project_holder.reset();
/* 122 */
/* 123 */       project_rowWriter.zeroOutNullBytes();
/* 124 */
/* 125 */       if (inputadapter_isNull) {
/* 126 */         project_rowWriter.setNullAt(0);
/* 127 */       } else {
/* 128 */         project_rowWriter.write(0, inputadapter_value);
/* 129 */       }
/* 130 */
/* 131 */       if (inputadapter_isNull1) {
/* 132 */         project_rowWriter.setNullAt(1);
/* 133 */       } else {
/* 134 */         project_rowWriter.write(1, inputadapter_value1);
/* 135 */       }
/* 136 */
/* 137 */       if (inputadapter_isNull2) {
/* 138 */         project_rowWriter.setNullAt(2);
/* 139 */       } else {
/* 140 */         project_rowWriter.write(2, inputadapter_value2);
/* 141 */       }
/* 142 */
/* 143 */       if (inputadapter_isNull3) {
/* 144 */         project_rowWriter.setNullAt(3);
/* 145 */       } else {
/* 146 */         project_rowWriter.write(3, inputadapter_value3);
/* 147 */       }
/* 148 */
/* 149 */       project_rowWriter.write(4, inputadapter_value4);
/* 150 */
/* 151 */       if (inputadapter_isNull5) {
/* 152 */         project_rowWriter.setNullAt(5);
/* 153 */       } else {
/* 154 */         project_rowWriter.write(5, inputadapter_value5);
/* 155 */       }
/* 156 */
/* 157 */       if (inputadapter_isNull6) {
/* 158 */         project_rowWriter.setNullAt(6);
/* 159 */       } else {
/* 160 */         project_rowWriter.write(6, inputadapter_value6);
/* 161 */       }
/* 162 */
/* 163 */       project_rowWriter.write(7, inputadapter_value9);
/* 164 */
/* 165 */       project_rowWriter.write(8, inputadapter_value8);
/* 166 */       project_result.setTotalSize(project_holder.totalSize());
/* 167 */       append(project_result);
/* 168 */       if (shouldStop()) return;
/* 169 */     }
/* 170 */   }
/* 171 */ }
