/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow agg_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 027 */   private int agg_value12;
/* 028 */   private UnsafeRow agg_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 040 */
/* 041 */   public GeneratedIterator(Object[] references) {
/* 042 */     this.references = references;
/* 043 */   }
/* 044 */
/* 045 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 046 */     partitionIndex = index;
/* 047 */     this.inputs = inputs;
/* 048 */     wholestagecodegen_init_0();
/* 049 */     wholestagecodegen_init_1();
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void wholestagecodegen_init_0() {
/* 054 */     agg_initAgg = false;
/* 055 */
/* 056 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 057 */
/* 058 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 059 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 060 */     inputadapter_input = inputs[0];
/* 061 */     agg_result = new UnsafeRow(1);
/* 062 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 063 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 064 */
/* 065 */     agg_result1 = new UnsafeRow(3);
/* 066 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 067 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 068 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 069 */     filter_result = new UnsafeRow(3);
/* 070 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 075 */     agg_hashMap = agg_plan.createHashMap();
/* 076 */
/* 077 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 078 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 079 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 080 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 081 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 082 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 083 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 084 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 085 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 086 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 087 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 088 */       long inputadapter_value4 = inputadapter_isNull4 ? -1L : (inputadapter_row.getLong(4));
/* 089 */
/* 090 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 091 */
/* 092 */       UnsafeRow agg_fastAggBuffer = null;
/* 093 */
/* 094 */       if (agg_fastAggBuffer == null) {
/* 095 */         // generate grouping key
/* 096 */         agg_rowWriter.zeroOutNullBytes();
/* 097 */
/* 098 */         if (inputadapter_isNull) {
/* 099 */           agg_rowWriter.setNullAt(0);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(0, inputadapter_value);
/* 102 */         }
/* 103 */         agg_value12 = 42;
/* 104 */
/* 105 */         if (!inputadapter_isNull) {
/* 106 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 107 */         }
/* 108 */         if (true) {
/* 109 */           // try to get the buffer from hash map
/* 110 */           agg_unsafeRowAggBuffer =
/* 111 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 112 */         }
/* 113 */         if (agg_unsafeRowAggBuffer == null) {
/* 114 */           if (agg_sorter == null) {
/* 115 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 116 */           } else {
/* 117 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 118 */           }
/* 119 */
/* 120 */           // the hash map had be spilled, it should have enough memory now,
/* 121 */           // try  to allocate buffer again.
/* 122 */           agg_unsafeRowAggBuffer =
/* 123 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 124 */           if (agg_unsafeRowAggBuffer == null) {
/* 125 */             // failed to allocate the first page
/* 126 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 127 */           }
/* 128 */         }
/* 129 */       }
/* 130 */
/* 131 */       if (agg_fastAggBuffer != null) {
/* 132 */         // update fast row
/* 133 */
/* 134 */       } else {
/* 135 */         // update unsafe row
/* 136 */
/* 137 */         // common sub-expressions
/* 138 */
/* 139 */         // evaluate aggregate function
/* 140 */         boolean agg_isNull10 = true;
/* 141 */         double agg_value14 = -1.0;
/* 142 */
/* 143 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 144 */         double agg_value15 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 145 */         if (!agg_isNull11) {
/* 146 */           if (!inputadapter_isNull1) {
/* 147 */             agg_isNull10 = false; // resultCode could change nullability.
/* 148 */             agg_value14 = agg_value15 + inputadapter_value1;
/* 149 */
/* 150 */           }
/* 151 */
/* 152 */         }
/* 153 */         boolean agg_isNull13 = true;
/* 154 */         long agg_value17 = -1L;
/* 155 */
/* 156 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 157 */         long agg_value18 = agg_isNull14 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 158 */         if (!agg_isNull14) {
/* 159 */           if (!inputadapter_isNull2) {
/* 160 */             agg_isNull13 = false; // resultCode could change nullability.
/* 161 */             agg_value17 = agg_value18 + inputadapter_value2;
/* 162 */
/* 163 */           }
/* 164 */
/* 165 */         }
/* 166 */         boolean agg_isNull16 = true;
/* 167 */         double agg_value20 = -1.0;
/* 168 */
/* 169 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 170 */         double agg_value21 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 171 */         if (!agg_isNull17) {
/* 172 */           if (!inputadapter_isNull3) {
/* 173 */             agg_isNull16 = false; // resultCode could change nullability.
/* 174 */             agg_value20 = agg_value21 + inputadapter_value3;
/* 175 */
/* 176 */           }
/* 177 */
/* 178 */         }
/* 179 */         boolean agg_isNull19 = true;
/* 180 */         long agg_value23 = -1L;
/* 181 */
/* 182 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 183 */         long agg_value24 = agg_isNull20 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 184 */         if (!agg_isNull20) {
/* 185 */           if (!inputadapter_isNull4) {
/* 186 */             agg_isNull19 = false; // resultCode could change nullability.
/* 187 */             agg_value23 = agg_value24 + inputadapter_value4;
/* 188 */
/* 189 */           }
/* 190 */
/* 191 */         }
/* 192 */         // update unsafe row buffer
/* 193 */         if (!agg_isNull10) {
/* 194 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 195 */         } else {
/* 196 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 197 */         }
/* 198 */
/* 199 */         if (!agg_isNull13) {
/* 200 */           agg_unsafeRowAggBuffer.setLong(1, agg_value17);
/* 201 */         } else {
/* 202 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 203 */         }
/* 204 */
/* 205 */         if (!agg_isNull16) {
/* 206 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value20);
/* 207 */         } else {
/* 208 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 209 */         }
/* 210 */
/* 211 */         if (!agg_isNull19) {
/* 212 */           agg_unsafeRowAggBuffer.setLong(3, agg_value23);
/* 213 */         } else {
/* 214 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 215 */         }
/* 216 */
/* 217 */       }
/* 218 */       if (shouldStop()) return;
/* 219 */     }
/* 220 */
/* 221 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 222 */   }
/* 223 */
/* 224 */   private void wholestagecodegen_init_1() {
/* 225 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 226 */     project_result = new UnsafeRow(2);
/* 227 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 228 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 229 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 230 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 231 */
/* 232 */   }
/* 233 */
/* 234 */   protected void processNext() throws java.io.IOException {
/* 235 */     if (!agg_initAgg) {
/* 236 */       agg_initAgg = true;
/* 237 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 238 */       agg_doAggregateWithKeys();
/* 239 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 240 */     }
/* 241 */
/* 242 */     // output the result
/* 243 */
/* 244 */     while (agg_mapIter.next()) {
/* 245 */       wholestagecodegen_numOutputRows.add(1);
/* 246 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 247 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 248 */
/* 249 */       boolean agg_isNull22 = agg_aggKey.isNullAt(0);
/* 250 */       int agg_value26 = agg_isNull22 ? -1 : (agg_aggKey.getInt(0));
/* 251 */       boolean agg_isNull23 = agg_aggBuffer.isNullAt(0);
/* 252 */       double agg_value27 = agg_isNull23 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 253 */       boolean agg_isNull24 = agg_aggBuffer.isNullAt(1);
/* 254 */       long agg_value28 = agg_isNull24 ? -1L : (agg_aggBuffer.getLong(1));
/* 255 */       boolean agg_isNull25 = agg_aggBuffer.isNullAt(2);
/* 256 */       double agg_value29 = agg_isNull25 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 257 */       boolean agg_isNull26 = agg_aggBuffer.isNullAt(3);
/* 258 */       long agg_value30 = agg_isNull26 ? -1L : (agg_aggBuffer.getLong(3));
/* 259 */       boolean agg_isNull29 = agg_isNull24;
/* 260 */       double agg_value33 = -1.0;
/* 261 */       if (!agg_isNull24) {
/* 262 */         agg_value33 = (double) agg_value28;
/* 263 */       }
/* 264 */       boolean agg_isNull27 = false;
/* 265 */       double agg_value31 = -1.0;
/* 266 */       if (agg_isNull29 || agg_value33 == 0) {
/* 267 */         agg_isNull27 = true;
/* 268 */       } else {
/* 269 */         if (agg_isNull23) {
/* 270 */           agg_isNull27 = true;
/* 271 */         } else {
/* 272 */           agg_value31 = (double)(agg_value27 / agg_value33);
/* 273 */         }
/* 274 */       }
/* 275 */       boolean agg_isNull33 = agg_isNull26;
/* 276 */       double agg_value37 = -1.0;
/* 277 */       if (!agg_isNull26) {
/* 278 */         agg_value37 = (double) agg_value30;
/* 279 */       }
/* 280 */       boolean agg_isNull31 = false;
/* 281 */       double agg_value35 = -1.0;
/* 282 */       if (agg_isNull33 || agg_value37 == 0) {
/* 283 */         agg_isNull31 = true;
/* 284 */       } else {
/* 285 */         if (agg_isNull25) {
/* 286 */           agg_isNull31 = true;
/* 287 */         } else {
/* 288 */           agg_value35 = (double)(agg_value29 / agg_value37);
/* 289 */         }
/* 290 */       }
/* 291 */
/* 292 */       if (!(!(agg_isNull31))) continue;
/* 293 */
/* 294 */       boolean filter_isNull2 = true;
/* 295 */       boolean filter_value2 = false;
/* 296 */
/* 297 */       boolean filter_isNull4 = true;
/* 298 */       double filter_value4 = -1.0;
/* 299 */
/* 300 */       if (!false) {
/* 301 */         filter_isNull4 = false; // resultCode could change nullability.
/* 302 */         filter_value4 = 0.9D * -836.6780184016676D;
/* 303 */
/* 304 */       }
/* 305 */       if (!filter_isNull4) {
/* 306 */         filter_isNull2 = false; // resultCode could change nullability.
/* 307 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value35, filter_value4) > 0;
/* 308 */
/* 309 */       }
/* 310 */       if (filter_isNull2 || !filter_value2) continue;
/* 311 */
/* 312 */       filter_numOutputRows.add(1);
/* 313 */
/* 314 */       project_rowWriter.zeroOutNullBytes();
/* 315 */
/* 316 */       if (agg_isNull22) {
/* 317 */         project_rowWriter.setNullAt(0);
/* 318 */       } else {
/* 319 */         project_rowWriter.write(0, agg_value26);
/* 320 */       }
/* 321 */
/* 322 */       if (agg_isNull27) {
/* 323 */         project_rowWriter.setNullAt(1);
/* 324 */       } else {
/* 325 */         project_rowWriter.write(1, agg_value31);
/* 326 */       }
/* 327 */       append(project_result);
/* 328 */
/* 329 */       if (shouldStop()) return;
/* 330 */     }
/* 331 */
/* 332 */     agg_mapIter.close();
/* 333 */     if (agg_sorter == null) {
/* 334 */       agg_hashMap.free();
/* 335 */     }
/* 336 */   }
/* 337 */ }
