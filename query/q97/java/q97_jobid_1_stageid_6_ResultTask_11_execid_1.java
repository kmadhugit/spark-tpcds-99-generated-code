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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */
/* 022 */   public GeneratedIterator(Object[] references) {
/* 023 */     this.references = references;
/* 024 */   }
/* 025 */
/* 026 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 027 */     partitionIndex = index;
/* 028 */     this.inputs = inputs;
/* 029 */     agg_initAgg = false;
/* 030 */
/* 031 */     inputadapter_input = inputs[0];
/* 032 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 033 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 034 */     agg_result = new UnsafeRow(3);
/* 035 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 036 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 041 */     // initialize aggregation buffer
/* 042 */     final long agg_value = -1L;
/* 043 */     agg_bufIsNull = true;
/* 044 */     agg_bufValue = agg_value;
/* 045 */     final long agg_value1 = -1L;
/* 046 */     agg_bufIsNull1 = true;
/* 047 */     agg_bufValue1 = agg_value1;
/* 048 */     final long agg_value2 = -1L;
/* 049 */     agg_bufIsNull2 = true;
/* 050 */     agg_bufValue2 = agg_value2;
/* 051 */
/* 052 */     while (inputadapter_input.hasNext()) {
/* 053 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 054 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 055 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 056 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 057 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 058 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 059 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 060 */
/* 061 */       // do aggregate
/* 062 */       // common sub-expressions
/* 063 */       boolean agg_isNull9 = false;
/* 064 */       long agg_value9 = -1L;
/* 065 */       if (!false) {
/* 066 */         agg_value9 = (long) 0;
/* 067 */       }
/* 068 */       // evaluate aggregate function
/* 069 */       boolean agg_isNull12 = true;
/* 070 */       long agg_value12 = -1L;
/* 071 */
/* 072 */       boolean agg_isNull13 = agg_bufIsNull;
/* 073 */       long agg_value13 = agg_bufValue;
/* 074 */       if (agg_isNull13) {
/* 075 */         if (!agg_isNull9) {
/* 076 */           agg_isNull13 = false;
/* 077 */           agg_value13 = agg_value9;
/* 078 */         }
/* 079 */       }
/* 080 */
/* 081 */       if (!inputadapter_isNull) {
/* 082 */         agg_isNull12 = false; // resultCode could change nullability.
/* 083 */         agg_value12 = agg_value13 + inputadapter_value;
/* 084 */
/* 085 */       }
/* 086 */       boolean agg_isNull11 = agg_isNull12;
/* 087 */       long agg_value11 = agg_value12;
/* 088 */       if (agg_isNull11) {
/* 089 */         if (!agg_bufIsNull) {
/* 090 */           agg_isNull11 = false;
/* 091 */           agg_value11 = agg_bufValue;
/* 092 */         }
/* 093 */       }
/* 094 */       boolean agg_isNull18 = true;
/* 095 */       long agg_value18 = -1L;
/* 096 */
/* 097 */       boolean agg_isNull19 = agg_bufIsNull1;
/* 098 */       long agg_value19 = agg_bufValue1;
/* 099 */       if (agg_isNull19) {
/* 100 */         if (!agg_isNull9) {
/* 101 */           agg_isNull19 = false;
/* 102 */           agg_value19 = agg_value9;
/* 103 */         }
/* 104 */       }
/* 105 */
/* 106 */       if (!inputadapter_isNull1) {
/* 107 */         agg_isNull18 = false; // resultCode could change nullability.
/* 108 */         agg_value18 = agg_value19 + inputadapter_value1;
/* 109 */
/* 110 */       }
/* 111 */       boolean agg_isNull17 = agg_isNull18;
/* 112 */       long agg_value17 = agg_value18;
/* 113 */       if (agg_isNull17) {
/* 114 */         if (!agg_bufIsNull1) {
/* 115 */           agg_isNull17 = false;
/* 116 */           agg_value17 = agg_bufValue1;
/* 117 */         }
/* 118 */       }
/* 119 */       boolean agg_isNull24 = true;
/* 120 */       long agg_value24 = -1L;
/* 121 */
/* 122 */       boolean agg_isNull25 = agg_bufIsNull2;
/* 123 */       long agg_value25 = agg_bufValue2;
/* 124 */       if (agg_isNull25) {
/* 125 */         if (!agg_isNull9) {
/* 126 */           agg_isNull25 = false;
/* 127 */           agg_value25 = agg_value9;
/* 128 */         }
/* 129 */       }
/* 130 */
/* 131 */       if (!inputadapter_isNull2) {
/* 132 */         agg_isNull24 = false; // resultCode could change nullability.
/* 133 */         agg_value24 = agg_value25 + inputadapter_value2;
/* 134 */
/* 135 */       }
/* 136 */       boolean agg_isNull23 = agg_isNull24;
/* 137 */       long agg_value23 = agg_value24;
/* 138 */       if (agg_isNull23) {
/* 139 */         if (!agg_bufIsNull2) {
/* 140 */           agg_isNull23 = false;
/* 141 */           agg_value23 = agg_bufValue2;
/* 142 */         }
/* 143 */       }
/* 144 */       // update aggregation buffer
/* 145 */       agg_bufIsNull = agg_isNull11;
/* 146 */       agg_bufValue = agg_value11;
/* 147 */
/* 148 */       agg_bufIsNull1 = agg_isNull17;
/* 149 */       agg_bufValue1 = agg_value17;
/* 150 */
/* 151 */       agg_bufIsNull2 = agg_isNull23;
/* 152 */       agg_bufValue2 = agg_value23;
/* 153 */       if (shouldStop()) return;
/* 154 */     }
/* 155 */
/* 156 */   }
/* 157 */
/* 158 */   protected void processNext() throws java.io.IOException {
/* 159 */     while (!agg_initAgg) {
/* 160 */       agg_initAgg = true;
/* 161 */       long agg_beforeAgg = System.nanoTime();
/* 162 */       agg_doAggregateWithoutKey();
/* 163 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 164 */
/* 165 */       // output the result
/* 166 */
/* 167 */       agg_numOutputRows.add(1);
/* 168 */       agg_rowWriter.zeroOutNullBytes();
/* 169 */
/* 170 */       if (agg_bufIsNull) {
/* 171 */         agg_rowWriter.setNullAt(0);
/* 172 */       } else {
/* 173 */         agg_rowWriter.write(0, agg_bufValue);
/* 174 */       }
/* 175 */
/* 176 */       if (agg_bufIsNull1) {
/* 177 */         agg_rowWriter.setNullAt(1);
/* 178 */       } else {
/* 179 */         agg_rowWriter.write(1, agg_bufValue1);
/* 180 */       }
/* 181 */
/* 182 */       if (agg_bufIsNull2) {
/* 183 */         agg_rowWriter.setNullAt(2);
/* 184 */       } else {
/* 185 */         agg_rowWriter.write(2, agg_bufValue2);
/* 186 */       }
/* 187 */       append(agg_result);
/* 188 */     }
/* 189 */   }
/* 190 */ }
