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
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private UnsafeRow scan_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     wholestagecodegen_init_0();
/* 050 */     wholestagecodegen_init_1();
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void wholestagecodegen_init_0() {
/* 055 */     scan_input = inputs[0];
/* 056 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 057 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 058 */     scan_scanTime1 = 0;
/* 059 */     scan_batch = null;
/* 060 */     scan_batchIdx = 0;
/* 061 */     scan_colInstance0 = null;
/* 062 */     scan_colInstance1 = null;
/* 063 */     scan_colInstance2 = null;
/* 064 */     scan_colInstance3 = null;
/* 065 */     scan_colInstance4 = null;
/* 066 */     scan_colInstance5 = null;
/* 067 */     scan_colInstance6 = null;
/* 068 */     scan_colInstance7 = null;
/* 069 */     scan_colInstance8 = null;
/* 070 */     scan_colInstance9 = null;
/* 071 */     scan_colInstance10 = null;
/* 072 */     scan_colInstance11 = null;
/* 073 */     scan_colInstance12 = null;
/* 074 */     scan_colInstance13 = null;
/* 075 */     scan_colInstance14 = null;
/* 076 */     scan_colInstance15 = null;
/* 077 */     scan_colInstance16 = null;
/* 078 */     scan_colInstance17 = null;
/* 079 */     scan_colInstance18 = null;
/* 080 */     scan_colInstance19 = null;
/* 081 */     scan_colInstance20 = null;
/* 082 */     scan_colInstance21 = null;
/* 083 */     scan_colInstance22 = null;
/* 084 */     scan_colInstance23 = null;
/* 085 */     scan_result = new UnsafeRow(24);
/* 086 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void scan_nextBatch() throws java.io.IOException {
/* 091 */     long getBatchStart = System.nanoTime();
/* 092 */     if (scan_input.hasNext()) {
/* 093 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 094 */       scan_numOutputRows.add(scan_batch.numRows());
/* 095 */       scan_batchIdx = 0;
/* 096 */       scan_colInstance0 = scan_batch.column(0);
/* 097 */       scan_colInstance1 = scan_batch.column(1);
/* 098 */       scan_colInstance2 = scan_batch.column(2);
/* 099 */       scan_colInstance3 = scan_batch.column(3);
/* 100 */       scan_colInstance4 = scan_batch.column(4);
/* 101 */       scan_colInstance5 = scan_batch.column(5);
/* 102 */       scan_colInstance6 = scan_batch.column(6);
/* 103 */       scan_colInstance7 = scan_batch.column(7);
/* 104 */       scan_colInstance8 = scan_batch.column(8);
/* 105 */       scan_colInstance9 = scan_batch.column(9);
/* 106 */       scan_colInstance10 = scan_batch.column(10);
/* 107 */       scan_colInstance11 = scan_batch.column(11);
/* 108 */       scan_colInstance12 = scan_batch.column(12);
/* 109 */       scan_colInstance13 = scan_batch.column(13);
/* 110 */       scan_colInstance14 = scan_batch.column(14);
/* 111 */       scan_colInstance15 = scan_batch.column(15);
/* 112 */       scan_colInstance16 = scan_batch.column(16);
/* 113 */       scan_colInstance17 = scan_batch.column(17);
/* 114 */       scan_colInstance18 = scan_batch.column(18);
/* 115 */       scan_colInstance19 = scan_batch.column(19);
/* 116 */       scan_colInstance20 = scan_batch.column(20);
/* 117 */       scan_colInstance21 = scan_batch.column(21);
/* 118 */       scan_colInstance22 = scan_batch.column(22);
/* 119 */       scan_colInstance23 = scan_batch.column(23);
/* 120 */
/* 121 */     }
/* 122 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 123 */   }
/* 124 */
/* 125 */   private void wholestagecodegen_init_1() {
/* 126 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 24);
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */   protected void processNext() throws java.io.IOException {
/* 131 */     if (scan_batch == null) {
/* 132 */       scan_nextBatch();
/* 133 */     }
/* 134 */     while (scan_batch != null) {
/* 135 */       int scan_numRows = scan_batch.numRows();
/* 136 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 137 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 138 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 139 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 140 */         long scan_value = scan_isNull ? -1L : (scan_colInstance0.getLong(scan_rowIdx));
/* 141 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 142 */         long scan_value1 = scan_isNull1 ? -1L : (scan_colInstance1.getLong(scan_rowIdx));
/* 143 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 144 */         long scan_value2 = scan_isNull2 ? -1L : (scan_colInstance2.getLong(scan_rowIdx));
/* 145 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 146 */         long scan_value3 = scan_isNull3 ? -1L : (scan_colInstance3.getLong(scan_rowIdx));
/* 147 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 148 */         long scan_value4 = scan_isNull4 ? -1L : (scan_colInstance4.getLong(scan_rowIdx));
/* 149 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 150 */         long scan_value5 = scan_isNull5 ? -1L : (scan_colInstance5.getLong(scan_rowIdx));
/* 151 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 152 */         long scan_value6 = scan_isNull6 ? -1L : (scan_colInstance6.getLong(scan_rowIdx));
/* 153 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 154 */         long scan_value7 = scan_isNull7 ? -1L : (scan_colInstance7.getLong(scan_rowIdx));
/* 155 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 156 */         long scan_value8 = scan_isNull8 ? -1L : (scan_colInstance8.getLong(scan_rowIdx));
/* 157 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 158 */         long scan_value9 = scan_isNull9 ? -1L : (scan_colInstance9.getLong(scan_rowIdx));
/* 159 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 160 */         long scan_value10 = scan_isNull10 ? -1L : (scan_colInstance10.getLong(scan_rowIdx));
/* 161 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 162 */         long scan_value11 = scan_isNull11 ? -1L : (scan_colInstance11.getLong(scan_rowIdx));
/* 163 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 164 */         long scan_value12 = scan_isNull12 ? -1L : (scan_colInstance12.getLong(scan_rowIdx));
/* 165 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 166 */         long scan_value13 = scan_isNull13 ? -1L : (scan_colInstance13.getLong(scan_rowIdx));
/* 167 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 168 */         double scan_value14 = scan_isNull14 ? -1.0 : (scan_colInstance14.getDouble(scan_rowIdx));
/* 169 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 170 */         double scan_value15 = scan_isNull15 ? -1.0 : (scan_colInstance15.getDouble(scan_rowIdx));
/* 171 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 172 */         double scan_value16 = scan_isNull16 ? -1.0 : (scan_colInstance16.getDouble(scan_rowIdx));
/* 173 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 174 */         double scan_value17 = scan_isNull17 ? -1.0 : (scan_colInstance17.getDouble(scan_rowIdx));
/* 175 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 176 */         double scan_value18 = scan_isNull18 ? -1.0 : (scan_colInstance18.getDouble(scan_rowIdx));
/* 177 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 178 */         double scan_value19 = scan_isNull19 ? -1.0 : (scan_colInstance19.getDouble(scan_rowIdx));
/* 179 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 180 */         double scan_value20 = scan_isNull20 ? -1.0 : (scan_colInstance20.getDouble(scan_rowIdx));
/* 181 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 182 */         double scan_value21 = scan_isNull21 ? -1.0 : (scan_colInstance21.getDouble(scan_rowIdx));
/* 183 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 184 */         double scan_value22 = scan_isNull22 ? -1.0 : (scan_colInstance22.getDouble(scan_rowIdx));
/* 185 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 186 */         int scan_value23 = scan_isNull23 ? -1 : (scan_colInstance23.getInt(scan_rowIdx));
/* 187 */         scan_rowWriter.zeroOutNullBytes();
/* 188 */
/* 189 */         if (scan_isNull) {
/* 190 */           scan_rowWriter.setNullAt(0);
/* 191 */         } else {
/* 192 */           scan_rowWriter.write(0, scan_value);
/* 193 */         }
/* 194 */
/* 195 */         if (scan_isNull1) {
/* 196 */           scan_rowWriter.setNullAt(1);
/* 197 */         } else {
/* 198 */           scan_rowWriter.write(1, scan_value1);
/* 199 */         }
/* 200 */
/* 201 */         if (scan_isNull2) {
/* 202 */           scan_rowWriter.setNullAt(2);
/* 203 */         } else {
/* 204 */           scan_rowWriter.write(2, scan_value2);
/* 205 */         }
/* 206 */
/* 207 */         if (scan_isNull3) {
/* 208 */           scan_rowWriter.setNullAt(3);
/* 209 */         } else {
/* 210 */           scan_rowWriter.write(3, scan_value3);
/* 211 */         }
/* 212 */
/* 213 */         if (scan_isNull4) {
/* 214 */           scan_rowWriter.setNullAt(4);
/* 215 */         } else {
/* 216 */           scan_rowWriter.write(4, scan_value4);
/* 217 */         }
/* 218 */
/* 219 */         if (scan_isNull5) {
/* 220 */           scan_rowWriter.setNullAt(5);
/* 221 */         } else {
/* 222 */           scan_rowWriter.write(5, scan_value5);
/* 223 */         }
/* 224 */
/* 225 */         if (scan_isNull6) {
/* 226 */           scan_rowWriter.setNullAt(6);
/* 227 */         } else {
/* 228 */           scan_rowWriter.write(6, scan_value6);
/* 229 */         }
/* 230 */
/* 231 */         if (scan_isNull7) {
/* 232 */           scan_rowWriter.setNullAt(7);
/* 233 */         } else {
/* 234 */           scan_rowWriter.write(7, scan_value7);
/* 235 */         }
/* 236 */
/* 237 */         if (scan_isNull8) {
/* 238 */           scan_rowWriter.setNullAt(8);
/* 239 */         } else {
/* 240 */           scan_rowWriter.write(8, scan_value8);
/* 241 */         }
/* 242 */
/* 243 */         if (scan_isNull9) {
/* 244 */           scan_rowWriter.setNullAt(9);
/* 245 */         } else {
/* 246 */           scan_rowWriter.write(9, scan_value9);
/* 247 */         }
/* 248 */
/* 249 */         if (scan_isNull10) {
/* 250 */           scan_rowWriter.setNullAt(10);
/* 251 */         } else {
/* 252 */           scan_rowWriter.write(10, scan_value10);
/* 253 */         }
/* 254 */
/* 255 */         if (scan_isNull11) {
/* 256 */           scan_rowWriter.setNullAt(11);
/* 257 */         } else {
/* 258 */           scan_rowWriter.write(11, scan_value11);
/* 259 */         }
/* 260 */
/* 261 */         if (scan_isNull12) {
/* 262 */           scan_rowWriter.setNullAt(12);
/* 263 */         } else {
/* 264 */           scan_rowWriter.write(12, scan_value12);
/* 265 */         }
/* 266 */
/* 267 */         if (scan_isNull13) {
/* 268 */           scan_rowWriter.setNullAt(13);
/* 269 */         } else {
/* 270 */           scan_rowWriter.write(13, scan_value13);
/* 271 */         }
/* 272 */
/* 273 */         if (scan_isNull14) {
/* 274 */           scan_rowWriter.setNullAt(14);
/* 275 */         } else {
/* 276 */           scan_rowWriter.write(14, scan_value14);
/* 277 */         }
/* 278 */
/* 279 */         if (scan_isNull15) {
/* 280 */           scan_rowWriter.setNullAt(15);
/* 281 */         } else {
/* 282 */           scan_rowWriter.write(15, scan_value15);
/* 283 */         }
/* 284 */
/* 285 */         if (scan_isNull16) {
/* 286 */           scan_rowWriter.setNullAt(16);
/* 287 */         } else {
/* 288 */           scan_rowWriter.write(16, scan_value16);
/* 289 */         }
/* 290 */
/* 291 */         if (scan_isNull17) {
/* 292 */           scan_rowWriter.setNullAt(17);
/* 293 */         } else {
/* 294 */           scan_rowWriter.write(17, scan_value17);
/* 295 */         }
/* 296 */
/* 297 */         if (scan_isNull18) {
/* 298 */           scan_rowWriter.setNullAt(18);
/* 299 */         } else {
/* 300 */           scan_rowWriter.write(18, scan_value18);
/* 301 */         }
/* 302 */
/* 303 */         if (scan_isNull19) {
/* 304 */           scan_rowWriter.setNullAt(19);
/* 305 */         } else {
/* 306 */           scan_rowWriter.write(19, scan_value19);
/* 307 */         }
/* 308 */
/* 309 */         if (scan_isNull20) {
/* 310 */           scan_rowWriter.setNullAt(20);
/* 311 */         } else {
/* 312 */           scan_rowWriter.write(20, scan_value20);
/* 313 */         }
/* 314 */
/* 315 */         if (scan_isNull21) {
/* 316 */           scan_rowWriter.setNullAt(21);
/* 317 */         } else {
/* 318 */           scan_rowWriter.write(21, scan_value21);
/* 319 */         }
/* 320 */
/* 321 */         if (scan_isNull22) {
/* 322 */           scan_rowWriter.setNullAt(22);
/* 323 */         } else {
/* 324 */           scan_rowWriter.write(22, scan_value22);
/* 325 */         }
/* 326 */
/* 327 */         if (scan_isNull23) {
/* 328 */           scan_rowWriter.setNullAt(23);
/* 329 */         } else {
/* 330 */           scan_rowWriter.write(23, scan_value23);
/* 331 */         }
/* 332 */         append(scan_result);
/* 333 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 334 */       }
/* 335 */       scan_batchIdx = scan_numRows;
/* 336 */       scan_batch = null;
/* 337 */       scan_nextBatch();
/* 338 */     }
/* 339 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 340 */     scan_scanTime1 = 0;
/* 341 */   }
/* 342 */ }
