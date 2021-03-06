/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private UnsafeRow scan_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     wholestagecodegen_init_0();
/* 047 */     wholestagecodegen_init_1();
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void wholestagecodegen_init_0() {
/* 052 */     scan_input = inputs[0];
/* 053 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 054 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 055 */     scan_scanTime1 = 0;
/* 056 */     scan_batch = null;
/* 057 */     scan_batchIdx = 0;
/* 058 */     scan_colInstance0 = null;
/* 059 */     scan_colInstance1 = null;
/* 060 */     scan_colInstance2 = null;
/* 061 */     scan_colInstance3 = null;
/* 062 */     scan_colInstance4 = null;
/* 063 */     scan_colInstance5 = null;
/* 064 */     scan_colInstance6 = null;
/* 065 */     scan_colInstance7 = null;
/* 066 */     scan_colInstance8 = null;
/* 067 */     scan_colInstance9 = null;
/* 068 */     scan_colInstance10 = null;
/* 069 */     scan_colInstance11 = null;
/* 070 */     scan_colInstance12 = null;
/* 071 */     scan_colInstance13 = null;
/* 072 */     scan_result = new UnsafeRow(14);
/* 073 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 288);
/* 074 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 14);
/* 075 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 076 */     filter_result = new UnsafeRow(14);
/* 077 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   private void scan_nextBatch() throws java.io.IOException {
/* 082 */     long getBatchStart = System.nanoTime();
/* 083 */     if (scan_input.hasNext()) {
/* 084 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 085 */       scan_numOutputRows.add(scan_batch.numRows());
/* 086 */       scan_batchIdx = 0;
/* 087 */       scan_colInstance0 = scan_batch.column(0);
/* 088 */       scan_colInstance1 = scan_batch.column(1);
/* 089 */       scan_colInstance2 = scan_batch.column(2);
/* 090 */       scan_colInstance3 = scan_batch.column(3);
/* 091 */       scan_colInstance4 = scan_batch.column(4);
/* 092 */       scan_colInstance5 = scan_batch.column(5);
/* 093 */       scan_colInstance6 = scan_batch.column(6);
/* 094 */       scan_colInstance7 = scan_batch.column(7);
/* 095 */       scan_colInstance8 = scan_batch.column(8);
/* 096 */       scan_colInstance9 = scan_batch.column(9);
/* 097 */       scan_colInstance10 = scan_batch.column(10);
/* 098 */       scan_colInstance11 = scan_batch.column(11);
/* 099 */       scan_colInstance12 = scan_batch.column(12);
/* 100 */       scan_colInstance13 = scan_batch.column(13);
/* 101 */
/* 102 */     }
/* 103 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 104 */   }
/* 105 */
/* 106 */   private void wholestagecodegen_init_1() {
/* 107 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 14);
/* 108 */     project_result = new UnsafeRow(14);
/* 109 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 110 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 14);
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   protected void processNext() throws java.io.IOException {
/* 115 */     if (scan_batch == null) {
/* 116 */       scan_nextBatch();
/* 117 */     }
/* 118 */     while (scan_batch != null) {
/* 119 */       int numRows = scan_batch.numRows();
/* 120 */       while (scan_batchIdx < numRows) {
/* 121 */         int scan_rowIdx = scan_batchIdx++;
/* 122 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 123 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 124 */
/* 125 */         if (!(!(scan_isNull))) continue;
/* 126 */
/* 127 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 128 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 129 */
/* 130 */         if (!(!(scan_isNull2))) continue;
/* 131 */
/* 132 */         filter_numOutputRows.add(1);
/* 133 */
/* 134 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 135 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 136 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 137 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 138 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 139 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 140 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 141 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 142 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 143 */         UTF8String scan_value6 = scan_isNull6 ? null : (scan_colInstance6.getUTF8String(scan_rowIdx));
/* 144 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 145 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 146 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 147 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 148 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 149 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 150 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 151 */         UTF8String scan_value10 = scan_isNull10 ? null : (scan_colInstance10.getUTF8String(scan_rowIdx));
/* 152 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 153 */         UTF8String scan_value11 = scan_isNull11 ? null : (scan_colInstance11.getUTF8String(scan_rowIdx));
/* 154 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 155 */         UTF8String scan_value12 = scan_isNull12 ? null : (scan_colInstance12.getUTF8String(scan_rowIdx));
/* 156 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 157 */         UTF8String scan_value13 = scan_isNull13 ? null : (scan_colInstance13.getUTF8String(scan_rowIdx));
/* 158 */         project_holder.reset();
/* 159 */
/* 160 */         project_rowWriter.zeroOutNullBytes();
/* 161 */
/* 162 */         project_rowWriter.write(0, scan_value);
/* 163 */
/* 164 */         if (scan_isNull1) {
/* 165 */           project_rowWriter.setNullAt(1);
/* 166 */         } else {
/* 167 */           project_rowWriter.write(1, scan_value1);
/* 168 */         }
/* 169 */
/* 170 */         project_rowWriter.write(2, scan_value2);
/* 171 */
/* 172 */         if (scan_isNull3) {
/* 173 */           project_rowWriter.setNullAt(3);
/* 174 */         } else {
/* 175 */           project_rowWriter.write(3, scan_value3);
/* 176 */         }
/* 177 */
/* 178 */         if (scan_isNull4) {
/* 179 */           project_rowWriter.setNullAt(4);
/* 180 */         } else {
/* 181 */           project_rowWriter.write(4, scan_value4);
/* 182 */         }
/* 183 */
/* 184 */         if (scan_isNull5) {
/* 185 */           project_rowWriter.setNullAt(5);
/* 186 */         } else {
/* 187 */           project_rowWriter.write(5, scan_value5);
/* 188 */         }
/* 189 */
/* 190 */         if (scan_isNull6) {
/* 191 */           project_rowWriter.setNullAt(6);
/* 192 */         } else {
/* 193 */           project_rowWriter.write(6, scan_value6);
/* 194 */         }
/* 195 */
/* 196 */         if (scan_isNull7) {
/* 197 */           project_rowWriter.setNullAt(7);
/* 198 */         } else {
/* 199 */           project_rowWriter.write(7, scan_value7);
/* 200 */         }
/* 201 */
/* 202 */         if (scan_isNull8) {
/* 203 */           project_rowWriter.setNullAt(8);
/* 204 */         } else {
/* 205 */           project_rowWriter.write(8, scan_value8);
/* 206 */         }
/* 207 */
/* 208 */         if (scan_isNull9) {
/* 209 */           project_rowWriter.setNullAt(9);
/* 210 */         } else {
/* 211 */           project_rowWriter.write(9, scan_value9);
/* 212 */         }
/* 213 */
/* 214 */         if (scan_isNull10) {
/* 215 */           project_rowWriter.setNullAt(10);
/* 216 */         } else {
/* 217 */           project_rowWriter.write(10, scan_value10);
/* 218 */         }
/* 219 */
/* 220 */         if (scan_isNull11) {
/* 221 */           project_rowWriter.setNullAt(11);
/* 222 */         } else {
/* 223 */           project_rowWriter.write(11, scan_value11);
/* 224 */         }
/* 225 */
/* 226 */         if (scan_isNull12) {
/* 227 */           project_rowWriter.setNullAt(12);
/* 228 */         } else {
/* 229 */           project_rowWriter.write(12, scan_value12);
/* 230 */         }
/* 231 */
/* 232 */         if (scan_isNull13) {
/* 233 */           project_rowWriter.setNullAt(13);
/* 234 */         } else {
/* 235 */           project_rowWriter.write(13, scan_value13);
/* 236 */         }
/* 237 */         project_result.setTotalSize(project_holder.totalSize());
/* 238 */         append(project_result);
/* 239 */         if (shouldStop()) return;
/* 240 */       }
/* 241 */       scan_batch = null;
/* 242 */       scan_nextBatch();
/* 243 */     }
/* 244 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 245 */     scan_scanTime1 = 0;
/* 246 */   }
/* 247 */ }
