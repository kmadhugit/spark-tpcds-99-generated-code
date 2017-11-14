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
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(6);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
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
/* 068 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
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
/* 082 */         agg_holder.reset();
/* 083 */
/* 084 */         agg_rowWriter.zeroOutNullBytes();
/* 085 */
/* 086 */         if (inputadapter_isNull) {
/* 087 */           agg_rowWriter.setNullAt(0);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(0, inputadapter_value);
/* 090 */         }
/* 091 */
/* 092 */         if (inputadapter_isNull1) {
/* 093 */           agg_rowWriter.setNullAt(1);
/* 094 */         } else {
/* 095 */           agg_rowWriter.write(1, inputadapter_value1);
/* 096 */         }
/* 097 */
/* 098 */         if (inputadapter_isNull2) {
/* 099 */           agg_rowWriter.setNullAt(2);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(2, inputadapter_value2);
/* 102 */         }
/* 103 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 104 */         agg_value12 = 42;
/* 105 */
/* 106 */         if (!inputadapter_isNull) {
/* 107 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 108 */         }
/* 109 */
/* 110 */         if (!inputadapter_isNull1) {
/* 111 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 112 */         }
/* 113 */
/* 114 */         if (!inputadapter_isNull2) {
/* 115 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value12);
/* 116 */         }
/* 117 */         if (true) {
/* 118 */           // try to get the buffer from hash map
/* 119 */           agg_unsafeRowAggBuffer =
/* 120 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 121 */         }
/* 122 */         if (agg_unsafeRowAggBuffer == null) {
/* 123 */           if (agg_sorter == null) {
/* 124 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 125 */           } else {
/* 126 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 127 */           }
/* 128 */
/* 129 */           // the hash map had be spilled, it should have enough memory now,
/* 130 */           // try  to allocate buffer again.
/* 131 */           agg_unsafeRowAggBuffer =
/* 132 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 133 */           if (agg_unsafeRowAggBuffer == null) {
/* 134 */             // failed to allocate the first page
/* 135 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 136 */           }
/* 137 */         }
/* 138 */       }
/* 139 */
/* 140 */       if (agg_fastAggBuffer != null) {
/* 141 */         // update fast row
/* 142 */
/* 143 */       } else {
/* 144 */         // update unsafe row
/* 145 */
/* 146 */         // common sub-expressions
/* 147 */         boolean agg_isNull13 = false;
/* 148 */         double agg_value16 = -1.0;
/* 149 */         if (!false) {
/* 150 */           agg_value16 = (double) 0;
/* 151 */         }
/* 152 */         // evaluate aggregate function
/* 153 */         boolean agg_isNull16 = true;
/* 154 */         double agg_value19 = -1.0;
/* 155 */
/* 156 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 157 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 158 */         boolean agg_isNull17 = agg_isNull18;
/* 159 */         double agg_value20 = agg_value21;
/* 160 */         if (agg_isNull17) {
/* 161 */           if (!agg_isNull13) {
/* 162 */             agg_isNull17 = false;
/* 163 */             agg_value20 = agg_value16;
/* 164 */           }
/* 165 */         }
/* 166 */
/* 167 */         if (!inputadapter_isNull3) {
/* 168 */           agg_isNull16 = false; // resultCode could change nullability.
/* 169 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 170 */
/* 171 */         }
/* 172 */         boolean agg_isNull15 = agg_isNull16;
/* 173 */         double agg_value18 = agg_value19;
/* 174 */         if (agg_isNull15) {
/* 175 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 176 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 177 */           if (!agg_isNull20) {
/* 178 */             agg_isNull15 = false;
/* 179 */             agg_value18 = agg_value23;
/* 180 */           }
/* 181 */         }
/* 182 */         boolean agg_isNull22 = true;
/* 183 */         double agg_value25 = -1.0;
/* 184 */
/* 185 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 186 */         double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 187 */         boolean agg_isNull23 = agg_isNull24;
/* 188 */         double agg_value26 = agg_value27;
/* 189 */         if (agg_isNull23) {
/* 190 */           if (!agg_isNull13) {
/* 191 */             agg_isNull23 = false;
/* 192 */             agg_value26 = agg_value16;
/* 193 */           }
/* 194 */         }
/* 195 */
/* 196 */         if (!inputadapter_isNull4) {
/* 197 */           agg_isNull22 = false; // resultCode could change nullability.
/* 198 */           agg_value25 = agg_value26 + inputadapter_value4;
/* 199 */
/* 200 */         }
/* 201 */         boolean agg_isNull21 = agg_isNull22;
/* 202 */         double agg_value24 = agg_value25;
/* 203 */         if (agg_isNull21) {
/* 204 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 205 */           double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 206 */           if (!agg_isNull26) {
/* 207 */             agg_isNull21 = false;
/* 208 */             agg_value24 = agg_value29;
/* 209 */           }
/* 210 */         }
/* 211 */         boolean agg_isNull28 = true;
/* 212 */         double agg_value31 = -1.0;
/* 213 */
/* 214 */         boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 215 */         double agg_value33 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 216 */         boolean agg_isNull29 = agg_isNull30;
/* 217 */         double agg_value32 = agg_value33;
/* 218 */         if (agg_isNull29) {
/* 219 */           if (!agg_isNull13) {
/* 220 */             agg_isNull29 = false;
/* 221 */             agg_value32 = agg_value16;
/* 222 */           }
/* 223 */         }
/* 224 */
/* 225 */         if (!inputadapter_isNull5) {
/* 226 */           agg_isNull28 = false; // resultCode could change nullability.
/* 227 */           agg_value31 = agg_value32 + inputadapter_value5;
/* 228 */
/* 229 */         }
/* 230 */         boolean agg_isNull27 = agg_isNull28;
/* 231 */         double agg_value30 = agg_value31;
/* 232 */         if (agg_isNull27) {
/* 233 */           boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 234 */           double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 235 */           if (!agg_isNull32) {
/* 236 */             agg_isNull27 = false;
/* 237 */             agg_value30 = agg_value35;
/* 238 */           }
/* 239 */         }
/* 240 */         // update unsafe row buffer
/* 241 */         if (!agg_isNull15) {
/* 242 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 243 */         } else {
/* 244 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 245 */         }
/* 246 */
/* 247 */         if (!agg_isNull21) {
/* 248 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value24);
/* 249 */         } else {
/* 250 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 251 */         }
/* 252 */
/* 253 */         if (!agg_isNull27) {
/* 254 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value30);
/* 255 */         } else {
/* 256 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 257 */         }
/* 258 */
/* 259 */       }
/* 260 */       if (shouldStop()) return;
/* 261 */     }
/* 262 */
/* 263 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 264 */   }
/* 265 */
/* 266 */   protected void processNext() throws java.io.IOException {
/* 267 */     if (!agg_initAgg) {
/* 268 */       agg_initAgg = true;
/* 269 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 270 */       agg_doAggregateWithKeys();
/* 271 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 272 */     }
/* 273 */
/* 274 */     // output the result
/* 275 */
/* 276 */     while (agg_mapIter.next()) {
/* 277 */       wholestagecodegen_numOutputRows.add(1);
/* 278 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 279 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 280 */
/* 281 */       boolean agg_isNull33 = agg_aggKey.isNullAt(0);
/* 282 */       int agg_value36 = agg_isNull33 ? -1 : (agg_aggKey.getInt(0));
/* 283 */       boolean agg_isNull34 = agg_aggKey.isNullAt(1);
/* 284 */       int agg_value37 = agg_isNull34 ? -1 : (agg_aggKey.getInt(1));
/* 285 */       boolean agg_isNull35 = agg_aggKey.isNullAt(2);
/* 286 */       UTF8String agg_value38 = agg_isNull35 ? null : (agg_aggKey.getUTF8String(2));
/* 287 */       boolean agg_isNull36 = agg_aggBuffer.isNullAt(0);
/* 288 */       double agg_value39 = agg_isNull36 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 289 */       boolean agg_isNull37 = agg_aggBuffer.isNullAt(1);
/* 290 */       double agg_value40 = agg_isNull37 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 291 */       boolean agg_isNull38 = agg_aggBuffer.isNullAt(2);
/* 292 */       double agg_value41 = agg_isNull38 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 293 */
/* 294 */       agg_holder1.reset();
/* 295 */
/* 296 */       agg_rowWriter1.zeroOutNullBytes();
/* 297 */
/* 298 */       if (agg_isNull33) {
/* 299 */         agg_rowWriter1.setNullAt(0);
/* 300 */       } else {
/* 301 */         agg_rowWriter1.write(0, agg_value36);
/* 302 */       }
/* 303 */
/* 304 */       if (agg_isNull34) {
/* 305 */         agg_rowWriter1.setNullAt(1);
/* 306 */       } else {
/* 307 */         agg_rowWriter1.write(1, agg_value37);
/* 308 */       }
/* 309 */
/* 310 */       if (agg_isNull35) {
/* 311 */         agg_rowWriter1.setNullAt(2);
/* 312 */       } else {
/* 313 */         agg_rowWriter1.write(2, agg_value38);
/* 314 */       }
/* 315 */
/* 316 */       if (agg_isNull36) {
/* 317 */         agg_rowWriter1.setNullAt(3);
/* 318 */       } else {
/* 319 */         agg_rowWriter1.write(3, agg_value39);
/* 320 */       }
/* 321 */
/* 322 */       if (agg_isNull37) {
/* 323 */         agg_rowWriter1.setNullAt(4);
/* 324 */       } else {
/* 325 */         agg_rowWriter1.write(4, agg_value40);
/* 326 */       }
/* 327 */
/* 328 */       if (agg_isNull38) {
/* 329 */         agg_rowWriter1.setNullAt(5);
/* 330 */       } else {
/* 331 */         agg_rowWriter1.write(5, agg_value41);
/* 332 */       }
/* 333 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 334 */       append(agg_result1);
/* 335 */
/* 336 */       if (shouldStop()) return;
/* 337 */     }
/* 338 */
/* 339 */     agg_mapIter.close();
/* 340 */     if (agg_sorter == null) {
/* 341 */       agg_hashMap.free();
/* 342 */     }
/* 343 */   }
/* 344 */ }
