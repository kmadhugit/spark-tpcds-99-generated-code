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
/* 023 */   private int agg_value12;
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
/* 044 */     agg_result = new UnsafeRow(4);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(6);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 069 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 070 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 071 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 072 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 073 */
/* 074 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 075 */
/* 076 */       UnsafeRow agg_fastAggBuffer = null;
/* 077 */
/* 078 */       if (agg_fastAggBuffer == null) {
/* 079 */         // generate grouping key
/* 080 */         agg_holder.reset();
/* 081 */
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
/* 101 */
/* 102 */         if (inputadapter_isNull3) {
/* 103 */           agg_rowWriter.setNullAt(3);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(3, inputadapter_value3);
/* 106 */         }
/* 107 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 108 */         agg_value12 = 42;
/* 109 */
/* 110 */         if (!inputadapter_isNull) {
/* 111 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value12);
/* 112 */         }
/* 113 */
/* 114 */         if (!inputadapter_isNull1) {
/* 115 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull2) {
/* 119 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull3) {
/* 123 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value12);
/* 124 */         }
/* 125 */         if (true) {
/* 126 */           // try to get the buffer from hash map
/* 127 */           agg_unsafeRowAggBuffer =
/* 128 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 129 */         }
/* 130 */         if (agg_unsafeRowAggBuffer == null) {
/* 131 */           if (agg_sorter == null) {
/* 132 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 133 */           } else {
/* 134 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 135 */           }
/* 136 */
/* 137 */           // the hash map had be spilled, it should have enough memory now,
/* 138 */           // try  to allocate buffer again.
/* 139 */           agg_unsafeRowAggBuffer =
/* 140 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 141 */           if (agg_unsafeRowAggBuffer == null) {
/* 142 */             // failed to allocate the first page
/* 143 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 144 */           }
/* 145 */         }
/* 146 */       }
/* 147 */
/* 148 */       if (agg_fastAggBuffer != null) {
/* 149 */         // update fast row
/* 150 */
/* 151 */       } else {
/* 152 */         // update unsafe row
/* 153 */
/* 154 */         // common sub-expressions
/* 155 */         boolean agg_isNull15 = false;
/* 156 */         double agg_value17 = -1.0;
/* 157 */         if (!false) {
/* 158 */           agg_value17 = (double) 0;
/* 159 */         }
/* 160 */         // evaluate aggregate function
/* 161 */         boolean agg_isNull18 = true;
/* 162 */         double agg_value20 = -1.0;
/* 163 */
/* 164 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 165 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 166 */         boolean agg_isNull19 = agg_isNull20;
/* 167 */         double agg_value21 = agg_value22;
/* 168 */         if (agg_isNull19) {
/* 169 */           if (!agg_isNull15) {
/* 170 */             agg_isNull19 = false;
/* 171 */             agg_value21 = agg_value17;
/* 172 */           }
/* 173 */         }
/* 174 */
/* 175 */         if (!inputadapter_isNull4) {
/* 176 */           agg_isNull18 = false; // resultCode could change nullability.
/* 177 */           agg_value20 = agg_value21 + inputadapter_value4;
/* 178 */
/* 179 */         }
/* 180 */         boolean agg_isNull17 = agg_isNull18;
/* 181 */         double agg_value19 = agg_value20;
/* 182 */         if (agg_isNull17) {
/* 183 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 184 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 185 */           if (!agg_isNull22) {
/* 186 */             agg_isNull17 = false;
/* 187 */             agg_value19 = agg_value24;
/* 188 */           }
/* 189 */         }
/* 190 */         boolean agg_isNull24 = true;
/* 191 */         double agg_value26 = -1.0;
/* 192 */
/* 193 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 194 */         double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 195 */         boolean agg_isNull25 = agg_isNull26;
/* 196 */         double agg_value27 = agg_value28;
/* 197 */         if (agg_isNull25) {
/* 198 */           if (!agg_isNull15) {
/* 199 */             agg_isNull25 = false;
/* 200 */             agg_value27 = agg_value17;
/* 201 */           }
/* 202 */         }
/* 203 */
/* 204 */         if (!inputadapter_isNull5) {
/* 205 */           agg_isNull24 = false; // resultCode could change nullability.
/* 206 */           agg_value26 = agg_value27 + inputadapter_value5;
/* 207 */
/* 208 */         }
/* 209 */         boolean agg_isNull23 = agg_isNull24;
/* 210 */         double agg_value25 = agg_value26;
/* 211 */         if (agg_isNull23) {
/* 212 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 213 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 214 */           if (!agg_isNull28) {
/* 215 */             agg_isNull23 = false;
/* 216 */             agg_value25 = agg_value30;
/* 217 */           }
/* 218 */         }
/* 219 */         // update unsafe row buffer
/* 220 */         if (!agg_isNull17) {
/* 221 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value19);
/* 222 */         } else {
/* 223 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 224 */         }
/* 225 */
/* 226 */         if (!agg_isNull23) {
/* 227 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 228 */         } else {
/* 229 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 230 */         }
/* 231 */
/* 232 */       }
/* 233 */       if (shouldStop()) return;
/* 234 */     }
/* 235 */
/* 236 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 237 */   }
/* 238 */
/* 239 */   protected void processNext() throws java.io.IOException {
/* 240 */     if (!agg_initAgg) {
/* 241 */       agg_initAgg = true;
/* 242 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 243 */       agg_doAggregateWithKeys();
/* 244 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 245 */     }
/* 246 */
/* 247 */     // output the result
/* 248 */
/* 249 */     while (agg_mapIter.next()) {
/* 250 */       wholestagecodegen_numOutputRows.add(1);
/* 251 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 252 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 253 */
/* 254 */       boolean agg_isNull29 = agg_aggKey.isNullAt(0);
/* 255 */       UTF8String agg_value31 = agg_isNull29 ? null : (agg_aggKey.getUTF8String(0));
/* 256 */       boolean agg_isNull30 = agg_aggKey.isNullAt(1);
/* 257 */       int agg_value32 = agg_isNull30 ? -1 : (agg_aggKey.getInt(1));
/* 258 */       boolean agg_isNull31 = agg_aggKey.isNullAt(2);
/* 259 */       int agg_value33 = agg_isNull31 ? -1 : (agg_aggKey.getInt(2));
/* 260 */       boolean agg_isNull32 = agg_aggKey.isNullAt(3);
/* 261 */       UTF8String agg_value34 = agg_isNull32 ? null : (agg_aggKey.getUTF8String(3));
/* 262 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(0);
/* 263 */       double agg_value35 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 264 */       boolean agg_isNull34 = agg_aggBuffer.isNullAt(1);
/* 265 */       double agg_value36 = agg_isNull34 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 266 */
/* 267 */       agg_holder1.reset();
/* 268 */
/* 269 */       agg_rowWriter1.zeroOutNullBytes();
/* 270 */
/* 271 */       if (agg_isNull30) {
/* 272 */         agg_rowWriter1.setNullAt(0);
/* 273 */       } else {
/* 274 */         agg_rowWriter1.write(0, agg_value32);
/* 275 */       }
/* 276 */
/* 277 */       if (agg_isNull29) {
/* 278 */         agg_rowWriter1.setNullAt(1);
/* 279 */       } else {
/* 280 */         agg_rowWriter1.write(1, agg_value31);
/* 281 */       }
/* 282 */
/* 283 */       if (agg_isNull31) {
/* 284 */         agg_rowWriter1.setNullAt(2);
/* 285 */       } else {
/* 286 */         agg_rowWriter1.write(2, agg_value33);
/* 287 */       }
/* 288 */
/* 289 */       if (agg_isNull32) {
/* 290 */         agg_rowWriter1.setNullAt(3);
/* 291 */       } else {
/* 292 */         agg_rowWriter1.write(3, agg_value34);
/* 293 */       }
/* 294 */
/* 295 */       if (agg_isNull33) {
/* 296 */         agg_rowWriter1.setNullAt(4);
/* 297 */       } else {
/* 298 */         agg_rowWriter1.write(4, agg_value35);
/* 299 */       }
/* 300 */
/* 301 */       if (agg_isNull34) {
/* 302 */         agg_rowWriter1.setNullAt(5);
/* 303 */       } else {
/* 304 */         agg_rowWriter1.write(5, agg_value36);
/* 305 */       }
/* 306 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 307 */       append(agg_result1);
/* 308 */
/* 309 */       if (shouldStop()) return;
/* 310 */     }
/* 311 */
/* 312 */     agg_mapIter.close();
/* 313 */     if (agg_sorter == null) {
/* 314 */       agg_hashMap.free();
/* 315 */     }
/* 316 */   }
/* 317 */ }
