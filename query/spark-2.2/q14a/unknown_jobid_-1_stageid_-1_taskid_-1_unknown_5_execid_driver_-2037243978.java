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
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value14;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(5);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(6);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 069 */       int inputadapter_value4 = inputadapter_row.getInt(4);
/* 070 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 071 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 072 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 073 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 074 */
/* 075 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 076 */
/* 077 */       UnsafeRow agg_fastAggBuffer = null;
/* 078 */
/* 079 */       if (agg_fastAggBuffer == null) {
/* 080 */         // generate grouping key
/* 081 */         agg_holder.reset();
/* 082 */
/* 083 */         agg_rowWriter.zeroOutNullBytes();
/* 084 */
/* 085 */         if (inputadapter_isNull) {
/* 086 */           agg_rowWriter.setNullAt(0);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(0, inputadapter_value);
/* 089 */         }
/* 090 */
/* 091 */         if (inputadapter_isNull1) {
/* 092 */           agg_rowWriter.setNullAt(1);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(1, inputadapter_value1);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull2) {
/* 098 */           agg_rowWriter.setNullAt(2);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(2, inputadapter_value2);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull3) {
/* 104 */           agg_rowWriter.setNullAt(3);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(3, inputadapter_value3);
/* 107 */         }
/* 108 */
/* 109 */         agg_rowWriter.write(4, inputadapter_value4);
/* 110 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 111 */         agg_value14 = 42;
/* 112 */
/* 113 */         if (!inputadapter_isNull) {
/* 114 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 115 */         }
/* 116 */
/* 117 */         if (!inputadapter_isNull1) {
/* 118 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 119 */         }
/* 120 */
/* 121 */         if (!inputadapter_isNull2) {
/* 122 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 123 */         }
/* 124 */
/* 125 */         if (!inputadapter_isNull3) {
/* 126 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value14);
/* 127 */         }
/* 128 */
/* 129 */         agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value14);
/* 130 */         if (true) {
/* 131 */           // try to get the buffer from hash map
/* 132 */           agg_unsafeRowAggBuffer =
/* 133 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 134 */         }
/* 135 */         if (agg_unsafeRowAggBuffer == null) {
/* 136 */           if (agg_sorter == null) {
/* 137 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 138 */           } else {
/* 139 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 140 */           }
/* 141 */
/* 142 */           // the hash map had be spilled, it should have enough memory now,
/* 143 */           // try  to allocate buffer again.
/* 144 */           agg_unsafeRowAggBuffer =
/* 145 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 146 */           if (agg_unsafeRowAggBuffer == null) {
/* 147 */             // failed to allocate the first page
/* 148 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 149 */           }
/* 150 */         }
/* 151 */       }
/* 152 */
/* 153 */       if (agg_fastAggBuffer != null) {
/* 154 */         // update fast row
/* 155 */
/* 156 */       } else {
/* 157 */         // update unsafe row
/* 158 */
/* 159 */         // common sub-expressions
/* 160 */
/* 161 */         // evaluate aggregate function
/* 162 */         boolean agg_isNull19 = true;
/* 163 */         double agg_value21 = -1.0;
/* 164 */
/* 165 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 166 */         double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 167 */         boolean agg_isNull20 = agg_isNull21;
/* 168 */         double agg_value22 = agg_value23;
/* 169 */         if (agg_isNull20) {
/* 170 */           boolean agg_isNull22 = false;
/* 171 */           double agg_value24 = -1.0;
/* 172 */           if (!false) {
/* 173 */             agg_value24 = (double) 0;
/* 174 */           }
/* 175 */           if (!agg_isNull22) {
/* 176 */             agg_isNull20 = false;
/* 177 */             agg_value22 = agg_value24;
/* 178 */           }
/* 179 */         }
/* 180 */
/* 181 */         if (!inputadapter_isNull5) {
/* 182 */           agg_isNull19 = false; // resultCode could change nullability.
/* 183 */           agg_value21 = agg_value22 + inputadapter_value5;
/* 184 */
/* 185 */         }
/* 186 */         boolean agg_isNull18 = agg_isNull19;
/* 187 */         double agg_value20 = agg_value21;
/* 188 */         if (agg_isNull18) {
/* 189 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 190 */           double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 191 */           if (!agg_isNull25) {
/* 192 */             agg_isNull18 = false;
/* 193 */             agg_value20 = agg_value27;
/* 194 */           }
/* 195 */         }
/* 196 */         boolean agg_isNull27 = true;
/* 197 */         long agg_value29 = -1L;
/* 198 */
/* 199 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 200 */         long agg_value31 = agg_isNull29 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 201 */         boolean agg_isNull28 = agg_isNull29;
/* 202 */         long agg_value30 = agg_value31;
/* 203 */         if (agg_isNull28) {
/* 204 */           boolean agg_isNull30 = false;
/* 205 */           long agg_value32 = -1L;
/* 206 */           if (!false) {
/* 207 */             agg_value32 = (long) 0;
/* 208 */           }
/* 209 */           if (!agg_isNull30) {
/* 210 */             agg_isNull28 = false;
/* 211 */             agg_value30 = agg_value32;
/* 212 */           }
/* 213 */         }
/* 214 */
/* 215 */         if (!inputadapter_isNull6) {
/* 216 */           agg_isNull27 = false; // resultCode could change nullability.
/* 217 */           agg_value29 = agg_value30 + inputadapter_value6;
/* 218 */
/* 219 */         }
/* 220 */         boolean agg_isNull26 = agg_isNull27;
/* 221 */         long agg_value28 = agg_value29;
/* 222 */         if (agg_isNull26) {
/* 223 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 224 */           long agg_value35 = agg_isNull33 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 225 */           if (!agg_isNull33) {
/* 226 */             agg_isNull26 = false;
/* 227 */             agg_value28 = agg_value35;
/* 228 */           }
/* 229 */         }
/* 230 */         // update unsafe row buffer
/* 231 */         if (!agg_isNull18) {
/* 232 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 233 */         } else {
/* 234 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 235 */         }
/* 236 */
/* 237 */         if (!agg_isNull26) {
/* 238 */           agg_unsafeRowAggBuffer.setLong(1, agg_value28);
/* 239 */         } else {
/* 240 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 241 */         }
/* 242 */
/* 243 */       }
/* 244 */       if (shouldStop()) return;
/* 245 */     }
/* 246 */
/* 247 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 248 */   }
/* 249 */
/* 250 */   protected void processNext() throws java.io.IOException {
/* 251 */     if (!agg_initAgg) {
/* 252 */       agg_initAgg = true;
/* 253 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 254 */       agg_doAggregateWithKeys();
/* 255 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 256 */     }
/* 257 */
/* 258 */     // output the result
/* 259 */
/* 260 */     while (agg_mapIter.next()) {
/* 261 */       wholestagecodegen_numOutputRows.add(1);
/* 262 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 263 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 264 */
/* 265 */       boolean agg_isNull34 = agg_aggKey.isNullAt(0);
/* 266 */       UTF8String agg_value36 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(0));
/* 267 */       boolean agg_isNull35 = agg_aggKey.isNullAt(1);
/* 268 */       int agg_value37 = agg_isNull35 ? -1 : (agg_aggKey.getInt(1));
/* 269 */       boolean agg_isNull36 = agg_aggKey.isNullAt(2);
/* 270 */       int agg_value38 = agg_isNull36 ? -1 : (agg_aggKey.getInt(2));
/* 271 */       boolean agg_isNull37 = agg_aggKey.isNullAt(3);
/* 272 */       int agg_value39 = agg_isNull37 ? -1 : (agg_aggKey.getInt(3));
/* 273 */       int agg_value40 = agg_aggKey.getInt(4);
/* 274 */       boolean agg_isNull39 = agg_aggBuffer.isNullAt(0);
/* 275 */       double agg_value41 = agg_isNull39 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 276 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(1);
/* 277 */       long agg_value42 = agg_isNull40 ? -1L : (agg_aggBuffer.getLong(1));
/* 278 */
/* 279 */       agg_holder1.reset();
/* 280 */
/* 281 */       agg_rowWriter1.zeroOutNullBytes();
/* 282 */
/* 283 */       if (agg_isNull34) {
/* 284 */         agg_rowWriter1.setNullAt(0);
/* 285 */       } else {
/* 286 */         agg_rowWriter1.write(0, agg_value36);
/* 287 */       }
/* 288 */
/* 289 */       if (agg_isNull35) {
/* 290 */         agg_rowWriter1.setNullAt(1);
/* 291 */       } else {
/* 292 */         agg_rowWriter1.write(1, agg_value37);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_isNull36) {
/* 296 */         agg_rowWriter1.setNullAt(2);
/* 297 */       } else {
/* 298 */         agg_rowWriter1.write(2, agg_value38);
/* 299 */       }
/* 300 */
/* 301 */       if (agg_isNull37) {
/* 302 */         agg_rowWriter1.setNullAt(3);
/* 303 */       } else {
/* 304 */         agg_rowWriter1.write(3, agg_value39);
/* 305 */       }
/* 306 */
/* 307 */       if (agg_isNull39) {
/* 308 */         agg_rowWriter1.setNullAt(4);
/* 309 */       } else {
/* 310 */         agg_rowWriter1.write(4, agg_value41);
/* 311 */       }
/* 312 */
/* 313 */       if (agg_isNull40) {
/* 314 */         agg_rowWriter1.setNullAt(5);
/* 315 */       } else {
/* 316 */         agg_rowWriter1.write(5, agg_value42);
/* 317 */       }
/* 318 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 319 */       append(agg_result1);
/* 320 */
/* 321 */       if (shouldStop()) return;
/* 322 */     }
/* 323 */
/* 324 */     agg_mapIter.close();
/* 325 */     if (agg_sorter == null) {
/* 326 */       agg_hashMap.free();
/* 327 */     }
/* 328 */   }
/* 329 */ }
