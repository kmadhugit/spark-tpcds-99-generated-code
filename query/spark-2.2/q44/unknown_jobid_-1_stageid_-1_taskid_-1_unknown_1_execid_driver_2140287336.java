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
/* 023 */   private int agg_value7;
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
/* 044 */     agg_result = new UnsafeRow(1);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(1);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
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
/* 062 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 067 */
/* 068 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 069 */
/* 070 */       UnsafeRow agg_fastAggBuffer = null;
/* 071 */
/* 072 */       if (agg_fastAggBuffer == null) {
/* 073 */         // generate grouping key
/* 074 */         agg_rowWriter.zeroOutNullBytes();
/* 075 */
/* 076 */         if (inputadapter_isNull) {
/* 077 */           agg_rowWriter.setNullAt(0);
/* 078 */         } else {
/* 079 */           agg_rowWriter.write(0, inputadapter_value);
/* 080 */         }
/* 081 */         agg_value7 = 42;
/* 082 */
/* 083 */         if (!inputadapter_isNull) {
/* 084 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value7);
/* 085 */         }
/* 086 */         if (true) {
/* 087 */           // try to get the buffer from hash map
/* 088 */           agg_unsafeRowAggBuffer =
/* 089 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 090 */         }
/* 091 */         if (agg_unsafeRowAggBuffer == null) {
/* 092 */           if (agg_sorter == null) {
/* 093 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 094 */           } else {
/* 095 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 096 */           }
/* 097 */
/* 098 */           // the hash map had be spilled, it should have enough memory now,
/* 099 */           // try  to allocate buffer again.
/* 100 */           agg_unsafeRowAggBuffer =
/* 101 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 102 */           if (agg_unsafeRowAggBuffer == null) {
/* 103 */             // failed to allocate the first page
/* 104 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 105 */           }
/* 106 */         }
/* 107 */       }
/* 108 */
/* 109 */       if (agg_fastAggBuffer != null) {
/* 110 */         // update fast row
/* 111 */
/* 112 */       } else {
/* 113 */         // update unsafe row
/* 114 */
/* 115 */         // common sub-expressions
/* 116 */
/* 117 */         // evaluate aggregate function
/* 118 */         boolean agg_isNull7 = true;
/* 119 */         double agg_value9 = -1.0;
/* 120 */
/* 121 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 122 */         double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 123 */         if (!agg_isNull8) {
/* 124 */           if (!inputadapter_isNull1) {
/* 125 */             agg_isNull7 = false; // resultCode could change nullability.
/* 126 */             agg_value9 = agg_value10 + inputadapter_value1;
/* 127 */
/* 128 */           }
/* 129 */
/* 130 */         }
/* 131 */         boolean agg_isNull10 = true;
/* 132 */         long agg_value12 = -1L;
/* 133 */
/* 134 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 135 */         long agg_value13 = agg_isNull11 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 136 */         if (!agg_isNull11) {
/* 137 */           if (!inputadapter_isNull2) {
/* 138 */             agg_isNull10 = false; // resultCode could change nullability.
/* 139 */             agg_value12 = agg_value13 + inputadapter_value2;
/* 140 */
/* 141 */           }
/* 142 */
/* 143 */         }
/* 144 */         // update unsafe row buffer
/* 145 */         if (!agg_isNull7) {
/* 146 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 147 */         } else {
/* 148 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 149 */         }
/* 150 */
/* 151 */         if (!agg_isNull10) {
/* 152 */           agg_unsafeRowAggBuffer.setLong(1, agg_value12);
/* 153 */         } else {
/* 154 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 155 */         }
/* 156 */
/* 157 */       }
/* 158 */       if (shouldStop()) return;
/* 159 */     }
/* 160 */
/* 161 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 162 */   }
/* 163 */
/* 164 */   protected void processNext() throws java.io.IOException {
/* 165 */     if (!agg_initAgg) {
/* 166 */       agg_initAgg = true;
/* 167 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 168 */       agg_doAggregateWithKeys();
/* 169 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 170 */     }
/* 171 */
/* 172 */     // output the result
/* 173 */
/* 174 */     while (agg_mapIter.next()) {
/* 175 */       wholestagecodegen_numOutputRows.add(1);
/* 176 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 177 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 178 */
/* 179 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 180 */       int agg_value15 = agg_isNull13 ? -1 : (agg_aggKey.getInt(0));
/* 181 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 182 */       double agg_value16 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 183 */       boolean agg_isNull15 = agg_aggBuffer.isNullAt(1);
/* 184 */       long agg_value17 = agg_isNull15 ? -1L : (agg_aggBuffer.getLong(1));
/* 185 */       boolean agg_isNull18 = agg_isNull15;
/* 186 */       double agg_value20 = -1.0;
/* 187 */       if (!agg_isNull15) {
/* 188 */         agg_value20 = (double) agg_value17;
/* 189 */       }
/* 190 */       boolean agg_isNull16 = false;
/* 191 */       double agg_value18 = -1.0;
/* 192 */       if (agg_isNull18 || agg_value20 == 0) {
/* 193 */         agg_isNull16 = true;
/* 194 */       } else {
/* 195 */         if (agg_isNull14) {
/* 196 */           agg_isNull16 = true;
/* 197 */         } else {
/* 198 */           agg_value18 = (double)(agg_value16 / agg_value20);
/* 199 */         }
/* 200 */       }
/* 201 */
/* 202 */       agg_rowWriter1.zeroOutNullBytes();
/* 203 */
/* 204 */       if (agg_isNull16) {
/* 205 */         agg_rowWriter1.setNullAt(0);
/* 206 */       } else {
/* 207 */         agg_rowWriter1.write(0, agg_value18);
/* 208 */       }
/* 209 */       append(agg_result1);
/* 210 */
/* 211 */       if (shouldStop()) return;
/* 212 */     }
/* 213 */
/* 214 */     agg_mapIter.close();
/* 215 */     if (agg_sorter == null) {
/* 216 */       agg_hashMap.free();
/* 217 */     }
/* 218 */   }
/* 219 */ }
