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
/* 042 */     final double agg_value = -1.0;
/* 043 */     agg_bufIsNull = true;
/* 044 */     agg_bufValue = agg_value;
/* 045 */     final double agg_value1 = -1.0;
/* 046 */     agg_bufIsNull1 = true;
/* 047 */     agg_bufValue1 = agg_value1;
/* 048 */     agg_bufIsNull2 = false;
/* 049 */     agg_bufValue2 = 0L;
/* 050 */
/* 051 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 052 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 053 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 054 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 055 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 056 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 057 */       long inputadapter_value2 = inputadapter_row.getLong(2);
/* 058 */
/* 059 */       // do aggregate
/* 060 */       // common sub-expressions
/* 061 */
/* 062 */       // evaluate aggregate function
/* 063 */       boolean agg_isNull10 = true;
/* 064 */       double agg_value10 = -1.0;
/* 065 */
/* 066 */       boolean agg_isNull11 = agg_bufIsNull;
/* 067 */       double agg_value11 = agg_bufValue;
/* 068 */       if (agg_isNull11) {
/* 069 */         boolean agg_isNull13 = false;
/* 070 */         double agg_value13 = -1.0;
/* 071 */         if (!false) {
/* 072 */           agg_value13 = (double) 0;
/* 073 */         }
/* 074 */         if (!agg_isNull13) {
/* 075 */           agg_isNull11 = false;
/* 076 */           agg_value11 = agg_value13;
/* 077 */         }
/* 078 */       }
/* 079 */
/* 080 */       if (!inputadapter_isNull) {
/* 081 */         agg_isNull10 = false; // resultCode could change nullability.
/* 082 */         agg_value10 = agg_value11 + inputadapter_value;
/* 083 */
/* 084 */       }
/* 085 */       boolean agg_isNull9 = agg_isNull10;
/* 086 */       double agg_value9 = agg_value10;
/* 087 */       if (agg_isNull9) {
/* 088 */         if (!agg_bufIsNull) {
/* 089 */           agg_isNull9 = false;
/* 090 */           agg_value9 = agg_bufValue;
/* 091 */         }
/* 092 */       }
/* 093 */       boolean agg_isNull18 = true;
/* 094 */       double agg_value18 = -1.0;
/* 095 */
/* 096 */       boolean agg_isNull19 = agg_bufIsNull1;
/* 097 */       double agg_value19 = agg_bufValue1;
/* 098 */       if (agg_isNull19) {
/* 099 */         boolean agg_isNull21 = false;
/* 100 */         double agg_value21 = -1.0;
/* 101 */         if (!false) {
/* 102 */           agg_value21 = (double) 0;
/* 103 */         }
/* 104 */         if (!agg_isNull21) {
/* 105 */           agg_isNull19 = false;
/* 106 */           agg_value19 = agg_value21;
/* 107 */         }
/* 108 */       }
/* 109 */
/* 110 */       if (!inputadapter_isNull1) {
/* 111 */         agg_isNull18 = false; // resultCode could change nullability.
/* 112 */         agg_value18 = agg_value19 + inputadapter_value1;
/* 113 */
/* 114 */       }
/* 115 */       boolean agg_isNull17 = agg_isNull18;
/* 116 */       double agg_value17 = agg_value18;
/* 117 */       if (agg_isNull17) {
/* 118 */         if (!agg_bufIsNull1) {
/* 119 */           agg_isNull17 = false;
/* 120 */           agg_value17 = agg_bufValue1;
/* 121 */         }
/* 122 */       }
/* 123 */       boolean agg_isNull25 = false;
/* 124 */
/* 125 */       long agg_value25 = -1L;
/* 126 */       agg_value25 = agg_bufValue2 + inputadapter_value2;
/* 127 */       // update aggregation buffer
/* 128 */       agg_bufIsNull = agg_isNull9;
/* 129 */       agg_bufValue = agg_value9;
/* 130 */
/* 131 */       agg_bufIsNull1 = agg_isNull17;
/* 132 */       agg_bufValue1 = agg_value17;
/* 133 */
/* 134 */       agg_bufIsNull2 = false;
/* 135 */       agg_bufValue2 = agg_value25;
/* 136 */       if (shouldStop()) return;
/* 137 */     }
/* 138 */
/* 139 */   }
/* 140 */
/* 141 */   protected void processNext() throws java.io.IOException {
/* 142 */     while (!agg_initAgg) {
/* 143 */       agg_initAgg = true;
/* 144 */       long agg_beforeAgg = System.nanoTime();
/* 145 */       agg_doAggregateWithoutKey();
/* 146 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 147 */
/* 148 */       // output the result
/* 149 */
/* 150 */       agg_numOutputRows.add(1);
/* 151 */       agg_rowWriter.zeroOutNullBytes();
/* 152 */
/* 153 */       if (agg_bufIsNull2) {
/* 154 */         agg_rowWriter.setNullAt(0);
/* 155 */       } else {
/* 156 */         agg_rowWriter.write(0, agg_bufValue2);
/* 157 */       }
/* 158 */
/* 159 */       if (agg_bufIsNull) {
/* 160 */         agg_rowWriter.setNullAt(1);
/* 161 */       } else {
/* 162 */         agg_rowWriter.write(1, agg_bufValue);
/* 163 */       }
/* 164 */
/* 165 */       if (agg_bufIsNull1) {
/* 166 */         agg_rowWriter.setNullAt(2);
/* 167 */       } else {
/* 168 */         agg_rowWriter.write(2, agg_bufValue1);
/* 169 */       }
/* 170 */       append(agg_result);
/* 171 */     }
/* 172 */   }
/* 173 */ }
