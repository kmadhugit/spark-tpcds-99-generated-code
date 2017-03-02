/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value12;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(3);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(6);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       long inputadapter_value3 = inputadapter_isNull3 ? -1L : (inputadapter_row.getLong(3));
/* 071 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 072 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 073 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 074 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 075 */
/* 076 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 077 */
/* 078 */       UnsafeRow agg_fastAggBuffer = null;
/* 079 */
/* 080 */       if (agg_fastAggBuffer == null) {
/* 081 */         // generate grouping key
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         if (inputadapter_isNull) {
/* 085 */           agg_rowWriter.setNullAt(0);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(0, inputadapter_value);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull1) {
/* 091 */           agg_rowWriter.setNullAt(1);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(1, inputadapter_value1);
/* 094 */         }
/* 095 */
/* 096 */         if (inputadapter_isNull2) {
/* 097 */           agg_rowWriter.setNullAt(2);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(2, inputadapter_value2);
/* 100 */         }
/* 101 */         agg_value12 = 42;
/* 102 */
/* 103 */         if (!inputadapter_isNull) {
/* 104 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 105 */         }
/* 106 */
/* 107 */         if (!inputadapter_isNull1) {
/* 108 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 109 */         }
/* 110 */
/* 111 */         if (!inputadapter_isNull2) {
/* 112 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 113 */         }
/* 114 */         if (true) {
/* 115 */           // try to get the buffer from hash map
/* 116 */           agg_unsafeRowAggBuffer =
/* 117 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 118 */         }
/* 119 */         if (agg_unsafeRowAggBuffer == null) {
/* 120 */           if (agg_sorter == null) {
/* 121 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 122 */           } else {
/* 123 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 124 */           }
/* 125 */
/* 126 */           // the hash map had be spilled, it should have enough memory now,
/* 127 */           // try  to allocate buffer again.
/* 128 */           agg_unsafeRowAggBuffer =
/* 129 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 130 */           if (agg_unsafeRowAggBuffer == null) {
/* 131 */             // failed to allocate the first page
/* 132 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 133 */           }
/* 134 */         }
/* 135 */       }
/* 136 */
/* 137 */       if (agg_fastAggBuffer != null) {
/* 138 */         // update fast row
/* 139 */
/* 140 */       } else {
/* 141 */         // update unsafe row
/* 142 */
/* 143 */         // common sub-expressions
/* 144 */         boolean agg_isNull13 = false;
/* 145 */         double agg_value16 = -1.0;
/* 146 */         if (!false) {
/* 147 */           agg_value16 = (double) 0;
/* 148 */         }
/* 149 */         // evaluate aggregate function
/* 150 */         boolean agg_isNull16 = true;
/* 151 */         long agg_value19 = -1L;
/* 152 */
/* 153 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 154 */         long agg_value21 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 155 */         boolean agg_isNull17 = agg_isNull18;
/* 156 */         long agg_value20 = agg_value21;
/* 157 */         if (agg_isNull17) {
/* 158 */           boolean agg_isNull19 = false;
/* 159 */           long agg_value22 = -1L;
/* 160 */           if (!false) {
/* 161 */             agg_value22 = (long) 0;
/* 162 */           }
/* 163 */           if (!agg_isNull19) {
/* 164 */             agg_isNull17 = false;
/* 165 */             agg_value20 = agg_value22;
/* 166 */           }
/* 167 */         }
/* 168 */
/* 169 */         if (!inputadapter_isNull3) {
/* 170 */           agg_isNull16 = false; // resultCode could change nullability.
/* 171 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 172 */
/* 173 */         }
/* 174 */         boolean agg_isNull15 = agg_isNull16;
/* 175 */         long agg_value18 = agg_value19;
/* 176 */         if (agg_isNull15) {
/* 177 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 178 */           long agg_value25 = agg_isNull22 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 179 */           if (!agg_isNull22) {
/* 180 */             agg_isNull15 = false;
/* 181 */             agg_value18 = agg_value25;
/* 182 */           }
/* 183 */         }
/* 184 */         boolean agg_isNull24 = true;
/* 185 */         double agg_value27 = -1.0;
/* 186 */
/* 187 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 188 */         double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 189 */         boolean agg_isNull25 = agg_isNull26;
/* 190 */         double agg_value28 = agg_value29;
/* 191 */         if (agg_isNull25) {
/* 192 */           if (!agg_isNull13) {
/* 193 */             agg_isNull25 = false;
/* 194 */             agg_value28 = agg_value16;
/* 195 */           }
/* 196 */         }
/* 197 */
/* 198 */         if (!inputadapter_isNull4) {
/* 199 */           agg_isNull24 = false; // resultCode could change nullability.
/* 200 */           agg_value27 = agg_value28 + inputadapter_value4;
/* 201 */
/* 202 */         }
/* 203 */         boolean agg_isNull23 = agg_isNull24;
/* 204 */         double agg_value26 = agg_value27;
/* 205 */         if (agg_isNull23) {
/* 206 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 207 */           double agg_value31 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 208 */           if (!agg_isNull28) {
/* 209 */             agg_isNull23 = false;
/* 210 */             agg_value26 = agg_value31;
/* 211 */           }
/* 212 */         }
/* 213 */         boolean agg_isNull30 = true;
/* 214 */         double agg_value33 = -1.0;
/* 215 */
/* 216 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 217 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 218 */         boolean agg_isNull31 = agg_isNull32;
/* 219 */         double agg_value34 = agg_value35;
/* 220 */         if (agg_isNull31) {
/* 221 */           if (!agg_isNull13) {
/* 222 */             agg_isNull31 = false;
/* 223 */             agg_value34 = agg_value16;
/* 224 */           }
/* 225 */         }
/* 226 */
/* 227 */         if (!inputadapter_isNull5) {
/* 228 */           agg_isNull30 = false; // resultCode could change nullability.
/* 229 */           agg_value33 = agg_value34 + inputadapter_value5;
/* 230 */
/* 231 */         }
/* 232 */         boolean agg_isNull29 = agg_isNull30;
/* 233 */         double agg_value32 = agg_value33;
/* 234 */         if (agg_isNull29) {
/* 235 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 236 */           double agg_value37 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 237 */           if (!agg_isNull34) {
/* 238 */             agg_isNull29 = false;
/* 239 */             agg_value32 = agg_value37;
/* 240 */           }
/* 241 */         }
/* 242 */         // update unsafe row buffer
/* 243 */         if (!agg_isNull15) {
/* 244 */           agg_unsafeRowAggBuffer.setLong(0, agg_value18);
/* 245 */         } else {
/* 246 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 247 */         }
/* 248 */
/* 249 */         if (!agg_isNull23) {
/* 250 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 251 */         } else {
/* 252 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 253 */         }
/* 254 */
/* 255 */         if (!agg_isNull29) {
/* 256 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 257 */         } else {
/* 258 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 259 */         }
/* 260 */
/* 261 */       }
/* 262 */       if (shouldStop()) return;
/* 263 */     }
/* 264 */
/* 265 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 266 */   }
/* 267 */
/* 268 */   protected void processNext() throws java.io.IOException {
/* 269 */     if (!agg_initAgg) {
/* 270 */       agg_initAgg = true;
/* 271 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 272 */       agg_doAggregateWithKeys();
/* 273 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 274 */     }
/* 275 */
/* 276 */     // output the result
/* 277 */
/* 278 */     while (agg_mapIter.next()) {
/* 279 */       wholestagecodegen_numOutputRows.add(1);
/* 280 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 281 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 282 */
/* 283 */       boolean agg_isNull35 = agg_aggKey.isNullAt(0);
/* 284 */       int agg_value38 = agg_isNull35 ? -1 : (agg_aggKey.getInt(0));
/* 285 */       boolean agg_isNull36 = agg_aggKey.isNullAt(1);
/* 286 */       int agg_value39 = agg_isNull36 ? -1 : (agg_aggKey.getInt(1));
/* 287 */       boolean agg_isNull37 = agg_aggKey.isNullAt(2);
/* 288 */       int agg_value40 = agg_isNull37 ? -1 : (agg_aggKey.getInt(2));
/* 289 */       boolean agg_isNull38 = agg_aggBuffer.isNullAt(0);
/* 290 */       long agg_value41 = agg_isNull38 ? -1L : (agg_aggBuffer.getLong(0));
/* 291 */       boolean agg_isNull39 = agg_aggBuffer.isNullAt(1);
/* 292 */       double agg_value42 = agg_isNull39 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 293 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(2);
/* 294 */       double agg_value43 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 295 */
/* 296 */       agg_rowWriter1.zeroOutNullBytes();
/* 297 */
/* 298 */       if (agg_isNull35) {
/* 299 */         agg_rowWriter1.setNullAt(0);
/* 300 */       } else {
/* 301 */         agg_rowWriter1.write(0, agg_value38);
/* 302 */       }
/* 303 */
/* 304 */       if (agg_isNull36) {
/* 305 */         agg_rowWriter1.setNullAt(1);
/* 306 */       } else {
/* 307 */         agg_rowWriter1.write(1, agg_value39);
/* 308 */       }
/* 309 */
/* 310 */       if (agg_isNull37) {
/* 311 */         agg_rowWriter1.setNullAt(2);
/* 312 */       } else {
/* 313 */         agg_rowWriter1.write(2, agg_value40);
/* 314 */       }
/* 315 */
/* 316 */       if (agg_isNull38) {
/* 317 */         agg_rowWriter1.setNullAt(3);
/* 318 */       } else {
/* 319 */         agg_rowWriter1.write(3, agg_value41);
/* 320 */       }
/* 321 */
/* 322 */       if (agg_isNull39) {
/* 323 */         agg_rowWriter1.setNullAt(4);
/* 324 */       } else {
/* 325 */         agg_rowWriter1.write(4, agg_value42);
/* 326 */       }
/* 327 */
/* 328 */       if (agg_isNull40) {
/* 329 */         agg_rowWriter1.setNullAt(5);
/* 330 */       } else {
/* 331 */         agg_rowWriter1.write(5, agg_value43);
/* 332 */       }
/* 333 */       append(agg_result1);
/* 334 */
/* 335 */       if (shouldStop()) return;
/* 336 */     }
/* 337 */
/* 338 */     agg_mapIter.close();
/* 339 */     if (agg_sorter == null) {
/* 340 */       agg_hashMap.free();
/* 341 */     }
/* 342 */   }
/* 343 */ }
